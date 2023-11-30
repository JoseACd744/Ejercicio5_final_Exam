package com.isa.platform.upc.Ejercicio5.monitoring.application.handlers;

import com.isa.platform.upc.Ejercicio5.inventory.domain.enums.MonitoringLevel;
import com.isa.platform.upc.Ejercicio5.inventory.domain.model.Product;
import com.isa.platform.upc.Ejercicio5.inventory.infrastructure.repositories.ProductRepository;
import com.isa.platform.upc.Ejercicio5.monitoring.application.commands.CreateSnapshotCommand;
import com.isa.platform.upc.Ejercicio5.monitoring.application.dtos.SnapshotRequestDTO;
import com.isa.platform.upc.Ejercicio5.monitoring.application.dtos.SnapshotResponseDTO;
import com.isa.platform.upc.Ejercicio5.monitoring.application.queries.GetSnapshotsByProductIdQuery;
import com.isa.platform.upc.Ejercicio5.monitoring.application.services.SnapshotQueryService;
import com.isa.platform.upc.Ejercicio5.monitoring.application.services.SnapshotCommandService;
import com.isa.platform.upc.Ejercicio5.monitoring.domain.model.Snapshot;
import com.isa.platform.upc.Ejercicio5.monitoring.infrastructure.repositories.SnapshotRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SnapshotHandler implements SnapshotQueryService, SnapshotCommandService{

    private final SnapshotRepository snapshotRepository;

    private final ModelMapper modelMapper;

    private final ProductRepository productRepository;

    @Autowired
    public SnapshotHandler(SnapshotRepository snapshotRepository, ModelMapper modelMapper, ProductRepository productRepository) {
        this.snapshotRepository = snapshotRepository;
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
    }

    @Override
    public SnapshotResponseDTO handle(CreateSnapshotCommand command) {
        if (snapshotRepository.existsById(command.snapshotRequestDTO().getProductId())) {
            throw new RuntimeException("A snapshot with the same product id already exists");
        }
        if (!productRepository.existsById(command.snapshotRequestDTO().getProductId())) {
            throw new RuntimeException("A product with the same id does not exist");
        }
        validateSnapshotForProduct(command.snapshotRequestDTO(), productRepository.findById(command.snapshotRequestDTO().getProductId()).orElseThrow(RuntimeException::new));
        Snapshot snapshot = modelMapper.map(command.snapshotRequestDTO(), Snapshot.class);
        Snapshot savedSnapshot = snapshotRepository.save(snapshot);
        return modelMapper.map(savedSnapshot, SnapshotResponseDTO.class);
    }

    @Override
    public List<SnapshotResponseDTO> handle(GetSnapshotsByProductIdQuery query) {
        Product product = productRepository.findById(query.productId())
                .orElseThrow(() -> new RuntimeException("Product with the given id does not exist"));

        return snapshotRepository.findByProduct(product)
                .stream()
                .map(snapshot -> modelMapper.map(snapshot, SnapshotResponseDTO.class))
                .collect(Collectors.toList());
    }


    private void validateSnapshotForProduct(SnapshotRequestDTO snapshotRequest, Product product) {
        if (product.getMonitoringLevel() == MonitoringLevel.ESSENTIAL_MONITORING
                && (snapshotRequest.getEnergy() != null || snapshotRequest.getLeakage() != null)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Snapshot Data not compatible with product current Monitoring Level");
        }

    }



}
