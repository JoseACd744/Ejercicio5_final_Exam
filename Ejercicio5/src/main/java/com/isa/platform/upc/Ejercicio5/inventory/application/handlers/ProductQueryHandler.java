package com.isa.platform.upc.Ejercicio5.inventory.application.handlers;

import com.isa.platform.upc.Ejercicio5.inventory.application.dtos.ProductResponseDTO;
import com.isa.platform.upc.Ejercicio5.inventory.application.queries.GetProductByIdQuery;
import com.isa.platform.upc.Ejercicio5.inventory.application.services.ProductQueryService;
import com.isa.platform.upc.Ejercicio5.inventory.infrastructure.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductQueryHandler implements ProductQueryService {

    private final ModelMapper modelMapper;

    private final ProductRepository productRepository;

    @Autowired
    public ProductQueryHandler(ModelMapper modelMapper, ProductRepository productRepository) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDTO handle(GetProductByIdQuery query) {
        return modelMapper.map(productRepository.findById(query.productId()).orElseThrow(RuntimeException::new), ProductResponseDTO.class);
    }
}
