package com.isa.platform.upc.Ejercicio5.monitoring.application.commands;

import com.isa.platform.upc.Ejercicio5.monitoring.application.dtos.SnapshotRequestDTO;

public record CreateSnapshotCommand(Long ProductId,SnapshotRequestDTO snapshotRequestDTO) {
}
