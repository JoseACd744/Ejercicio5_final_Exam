package com.isa.platform.upc.Ejercicio5.inventory.application.handlers;

import com.isa.platform.upc.Ejercicio5.inventory.application.commands.CreateProductCommand;
import com.isa.platform.upc.Ejercicio5.inventory.application.dtos.ProductResponseDTO;
import com.isa.platform.upc.Ejercicio5.inventory.application.services.ProductCommandService;
import com.isa.platform.upc.Ejercicio5.inventory.domain.model.Product;
import com.isa.platform.upc.Ejercicio5.inventory.infrastructure.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCommandHandler implements ProductCommandService {

    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    @Autowired
    public ProductCommandHandler(ModelMapper modelMapper, ProductRepository productRepository) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDTO handle(CreateProductCommand command) {
        if (productRepository.existsBySerialNumber(command.productRequestDTO().getSerialNumber())) {
            throw new RuntimeException("A product with the same serial number already exists");
        }
        Product product = modelMapper.map(command.productRequestDTO(), Product.class);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductResponseDTO.class);
    }
}