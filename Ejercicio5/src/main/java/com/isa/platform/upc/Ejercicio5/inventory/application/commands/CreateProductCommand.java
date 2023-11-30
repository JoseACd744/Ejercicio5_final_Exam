package com.isa.platform.upc.Ejercicio5.inventory.application.commands;

import com.isa.platform.upc.Ejercicio5.inventory.application.dtos.ProductRequestDTO;
import lombok.Getter;

public record CreateProductCommand(ProductRequestDTO productRequestDTO) {

}
