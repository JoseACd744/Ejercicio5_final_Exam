package com.isa.platform.upc.Ejercicio5.inventory.application.dtos;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ProductRequestDTO {
    private String brand;
    private String model;
    private String serialNumber;
    @Pattern(regexp = "ESSENTIAL_MONITORING|ADVANCE_MONITORING", message = "Invalid monitoring level")
    private String monitoringLevel;


}

