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
        Product product = productRepository.findById(command.ProductId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Product not found with id: " + command.ProductId()));

        validateSnapshotForProduct(command.snapshotRequestDTO(), product);
        Snapshot snapshot = modelMapper.map(command.snapshotRequestDTO(), Snapshot.class);
        snapshot.setProduct(product); // Set the product field
        Snapshot savedSnapshot = snapshotRepository.save(snapshot);
        return modelMapper.map(savedSnapshot, SnapshotResponseDTO.class);
    }

    @Override
    public List<SnapshotResponseDTO> handle(GetSnapshotsByProductIdQuery query){
        if (query.productId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Product Id is required");
        }
        if(!productRepository.existsById(query.productId())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found with id: " + query.productId());
        }
        List<Snapshot> snapshots = snapshotRepository.findByProductId(query.productId());
        if (snapshots.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No snapshots found for product with id: " + query.productId());
        }
        return snapshots.stream()
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
