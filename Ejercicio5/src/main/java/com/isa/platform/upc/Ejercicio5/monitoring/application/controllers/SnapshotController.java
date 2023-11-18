package com.isa.platform.upc.Ejercicio5.monitoring.application.controllers;

import com.isa.platform.upc.Ejercicio5.monitoring.application.dtos.SnapshotRequestDTO;
import com.isa.platform.upc.Ejercicio5.monitoring.application.dtos.SnapshotResponseDTO;
import com.isa.platform.upc.Ejercicio5.monitoring.application.services.SnapshotService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Snapshot Controller", description = "Controller for managing snapshots")
@RestController
@RequestMapping("/api/v1/")
public class SnapshotController {
    @Autowired

    private final ModelMapper modelMapper;

    private final SnapshotService snapshotService;

    public SnapshotController(ModelMapper modelMapper, SnapshotService snapshotService) {
        this.modelMapper = modelMapper;
        this.snapshotService = snapshotService;
    }

    @Operation(summary = "Create a new snapshot for a product")
    @ApiResponse(responseCode = "201", description = "Snapshot created", content = @Content(mediaType = "application/json", schema=@Schema(implementation = SnapshotResponseDTO.class)))
    @ApiResponse(responseCode = "400", description = "Invalid snapshot data", content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Product not found", content = @Content(mediaType = "application/json"))
    @Transactional
    @PostMapping("/products/{productId}/snapshots")
    public SnapshotResponseDTO addSnapshot(@PathVariable Long productId, @RequestBody SnapshotRequestDTO snapshotRequest) {
        return snapshotService.addSnapshot(productId, snapshotRequest);
    }
    @Operation(summary = "Get snapshots by product id")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema=@Schema(implementation = SnapshotResponseDTO.class)))
    @ApiResponse(responseCode = "404", description = "Product not found", content = @Content(mediaType = "application/json"))
    @Transactional(readOnly = true)
    @GetMapping("/products/{productId}/snapshots")
    public List<SnapshotResponseDTO> getSnapshotsByProductId(@PathVariable Long productId) {
        return snapshotService.getSnapshotsByProductId(productId);
    }
}
