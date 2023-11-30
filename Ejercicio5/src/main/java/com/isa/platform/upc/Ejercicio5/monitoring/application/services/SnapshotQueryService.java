package com.isa.platform.upc.Ejercicio5.monitoring.application.services;

import com.isa.platform.upc.Ejercicio5.monitoring.application.dtos.SnapshotResponseDTO;
import com.isa.platform.upc.Ejercicio5.monitoring.application.queries.GetSnapshotsByProductIdQuery;

import java.util.List;

public interface SnapshotQueryService {

    List<SnapshotResponseDTO> handle(GetSnapshotsByProductIdQuery query);
}
