package com.isa.platform.upc.Ejercicio5.monitoring.application.services.impl;

import com.isa.platform.upc.Ejercicio5.inventory.domain.enums.MonitoringLevel;
import com.isa.platform.upc.Ejercicio5.inventory.domain.model.Product;
import com.isa.platform.upc.Ejercicio5.inventory.infrastructure.repositories.ProductRepository;
import com.isa.platform.upc.Ejercicio5.monitoring.application.dtos.SnapshotRequestDTO;
import com.isa.platform.upc.Ejercicio5.monitoring.application.dtos.SnapshotResponseDTO;
import com.isa.platform.upc.Ejercicio5.monitoring.application.services.SnapshotService;
import com.isa.platform.upc.Ejercicio5.monitoring.domain.model.Snapshot;
import com.isa.platform.upc.Ejercicio5.monitoring.infrastructure.repositories.SnapshotRepository;
import com.isa.platform.upc.Ejercicio5.shared.exception.CustomException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SnapshotServiceImpl implements SnapshotService {

    private final SnapshotRepository snapshotRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public SnapshotServiceImpl(SnapshotRepository snapshotRepository, ProductRepository productRepository, ModelMapper modelMapper) {
        this.snapshotRepository = snapshotRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SnapshotResponseDTO addSnapshot(Long productId, SnapshotRequestDTO snapshotRequest) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Product not found with id: " + productId));

        validateSnapshotForProduct(snapshotRequest, product);
        Snapshot snapshot = modelMapper.map(snapshotRequest, Snapshot.class);
        snapshot.setProduct(product);
        snapshotRepository.save(snapshot);
        return modelMapper.map(snapshot, SnapshotResponseDTO.class);
    }

    @Override
    public List<SnapshotResponseDTO> getSnapshotsByProductId(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Product not found with id: " + productId));

        List<Snapshot> snapshots = snapshotRepository.findByProduct(product);

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


