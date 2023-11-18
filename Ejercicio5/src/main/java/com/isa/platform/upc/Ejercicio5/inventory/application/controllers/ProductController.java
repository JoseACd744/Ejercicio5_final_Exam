package com.isa.platform.upc.Ejercicio5.inventory.application.controllers;


import com.isa.platform.upc.Ejercicio5.inventory.application.dtos.ProductRequestDTO;
import com.isa.platform.upc.Ejercicio5.inventory.application.dtos.ProductResponseDTO;
import com.isa.platform.upc.Ejercicio5.inventory.application.services.ProductService;
import com.isa.platform.upc.Ejercicio5.inventory.infrastructure.repositories.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Product Controller", description = "Controller for managing products")
@RestController
@RequestMapping("/api/v1/")
public class ProductController {
    @Autowired
    private ProductService productService;
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    public ProductController( ModelMapper modelMapper, ProductRepository productRepository) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
    }

    @Operation(summary = "Get products by id", description = "Get products by id")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @Schema(implementation = ProductRequestDTO.class)))
    @Transactional(readOnly = true)
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id){
        ProductResponseDTO productResponseDTO = productService.getProductById(id);
        return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
    }

    @Operation(summary = "Create a product", description = "Create a product")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @Schema(implementation = ProductRequestDTO.class)))
    @Transactional
    @PostMapping("/products")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        // Call the service method
        ProductResponseDTO productResponseDTO = productService.createProduct(productRequestDTO);
        // Return the created product
        return new ResponseEntity<>(productResponseDTO, HttpStatus.CREATED);
    }


}
