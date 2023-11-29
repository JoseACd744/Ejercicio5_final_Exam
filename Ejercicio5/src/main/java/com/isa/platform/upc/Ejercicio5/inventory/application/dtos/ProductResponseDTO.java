package com.isa.platform.upc.Ejercicio5.inventory.application.dtos;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private Long id;
    private String brand;
    private String model;
    private String serialNumber;
    private String monitoringLevel; // Se retorna como String ("ESSENTIAL_MONITORING" o "ADVANCE_MONITORING")
    private String creationDateTime;
    private String lastUpdateDateTime;
}
