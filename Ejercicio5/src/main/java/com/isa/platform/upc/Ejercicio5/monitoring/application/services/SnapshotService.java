package com.isa.platform.upc.Ejercicio5.monitoring.application.services;

import com.isa.platform.upc.Ejercicio5.monitoring.application.dtos.SnapshotRequestDTO;
import com.isa.platform.upc.Ejercicio5.monitoring.application.dtos.SnapshotResponseDTO;

import java.util.List;

public interface SnapshotService {

    SnapshotResponseDTO addSnapshot(Long productId, SnapshotRequestDTO snapshotRequest);

    List<SnapshotResponseDTO> getSnapshotsByProductId(Long productId);
}
