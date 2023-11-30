package com.isa.platform.upc.Ejercicio5.monitoring.application.services;

import com.isa.platform.upc.Ejercicio5.monitoring.application.commands.CreateSnapshotCommand;
import com.isa.platform.upc.Ejercicio5.monitoring.application.dtos.SnapshotResponseDTO;

public interface SnapshotCommandService {


    SnapshotResponseDTO handle(CreateSnapshotCommand command);
}
