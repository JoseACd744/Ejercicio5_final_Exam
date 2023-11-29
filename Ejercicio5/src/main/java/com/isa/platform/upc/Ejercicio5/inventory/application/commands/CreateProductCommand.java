package com.isa.platform.upc.Ejercicio5.inventory.application.commands;

import com.isa.platform.upc.Ejercicio5.inventory.application.dtos.ProductRequestDTO;

public class CreateProductCommand {

    private final ProductRequestDTO productRequestDTO;

    public CreateProductCommand(ProductRequestDTO productRequestDTO) {
        this.productRequestDTO = productRequestDTO;
    }

    public ProductRequestDTO getProductRequestDTO() {
        return productRequestDTO;
    }
}
