package com.isa.platform.upc.Ejercicio5.inventory.application.controllers;

import com.isa.platform.upc.Ejercicio5.inventory.application.commands.CreateProductCommand;
import com.isa.platform.upc.Ejercicio5.inventory.application.dtos.ProductRequestDTO;
import com.isa.platform.upc.Ejercicio5.inventory.application.dtos.ProductResponseDTO;
import com.isa.platform.upc.Ejercicio5.inventory.application.queries.GetProductByIdQuery;
import com.isa.platform.upc.Ejercicio5.inventory.application.services.ProductCommandService;
import com.isa.platform.upc.Ejercicio5.inventory.application.services.ProductQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Product Controller", description = "Controller for managing products")
@RestController
@RequestMapping("/api/v1/")
public class ProductController {
    private final ProductCommandService productCommandService;
    private final ProductQueryService productQueryService;

    @Autowired
    public ProductController(ProductCommandService productCommandService, ProductQueryService productQueryService) {
        this.productCommandService = productCommandService;
        this.productQueryService = productQueryService;
    }

    @Operation(summary = "Get products by id", description = "Get products by id")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @Schema(implementation = ProductRequestDTO.class)))
    @Transactional(readOnly = true)
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id){
        GetProductByIdQuery query = new GetProductByIdQuery(id);
        ProductResponseDTO productResponseDTO = productQueryService.handle(query);
        return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
    }

    @Operation(summary = "Create a product", description = "Create a product")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @Schema(implementation = ProductRequestDTO.class)))
    @Transactional
    @PostMapping("/products")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        CreateProductCommand command = new CreateProductCommand(productRequestDTO);
        ProductResponseDTO productResponseDTO = productCommandService.handle(command);
        return new ResponseEntity<>(productResponseDTO, HttpStatus.CREATED);
    }
}