package com.isa.platform.upc.Ejercicio5.inventory.application.services.impl;

import com.isa.platform.upc.Ejercicio5.inventory.application.dtos.ProductRequestDTO;
import com.isa.platform.upc.Ejercicio5.inventory.application.dtos.ProductResponseDTO;
import com.isa.platform.upc.Ejercicio5.inventory.application.services.ProductService;
import com.isa.platform.upc.Ejercicio5.inventory.domain.model.Product;
import com.isa.platform.upc.Ejercicio5.inventory.infrastructure.repositories.ProductRepository;
import com.isa.platform.upc.Ejercicio5.shared.exception.ValidationException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
        @Autowired
        public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
            this.productRepository = productRepository;
            this.modelMapper = modelMapper;
        }
    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        if (productRepository.existsBySerialNumber(productRequestDTO.getSerialNumber())) {
            throw new ValidationException("A product with the same serial number already exists");
        }
        Product product = modelMapper.map(productRequestDTO, Product.class);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductResponseDTO.class);
    }

        @Override
        public ProductResponseDTO getProductById(Long id) {
            Product product = productRepository.findById(id).orElseThrow(() -> new ValidationException("The product with id: "+ id + " does not exist"));
            return modelMapper.map(product, ProductResponseDTO.class);
        }
}
