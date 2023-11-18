package com.isa.platform.upc.Ejercicio5.inventory.application.services;

import com.isa.platform.upc.Ejercicio5.inventory.application.dtos.ProductRequestDTO;
import com.isa.platform.upc.Ejercicio5.inventory.application.dtos.ProductResponseDTO;
import org.springframework.stereotype.Service;

public interface ProductService {

    public abstract ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);

    public abstract ProductResponseDTO getProductById(Long id);
}
