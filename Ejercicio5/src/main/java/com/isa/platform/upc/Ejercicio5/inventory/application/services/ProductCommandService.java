package com.isa.platform.upc.Ejercicio5.inventory.application.services;

import com.isa.platform.upc.Ejercicio5.inventory.application.commands.CreateProductCommand;
import com.isa.platform.upc.Ejercicio5.inventory.application.dtos.ProductResponseDTO;

public interface ProductCommandService {

    ProductResponseDTO handle(CreateProductCommand command);

}
