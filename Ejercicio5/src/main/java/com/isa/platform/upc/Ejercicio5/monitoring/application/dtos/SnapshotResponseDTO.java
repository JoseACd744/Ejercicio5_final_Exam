package com.isa.platform.upc.Ejercicio5.monitoring.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SnapshotResponseDTO {

    private Long id;
    private String snapshotId;
    private String productSerialNumber;
    private Double temperature;
    private Double energy;
    private Integer leakage;
}
