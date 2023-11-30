package com.isa.platform.upc.Ejercicio5.monitoring.application.controllers;


import com.isa.platform.upc.Ejercicio5.monitoring.application.commands.CreateSnapshotCommand;
import com.isa.platform.upc.Ejercicio5.monitoring.application.dtos.SnapshotRequestDTO;
import com.isa.platform.upc.Ejercicio5.monitoring.application.dtos.SnapshotResponseDTO;
import com.isa.platform.upc.Ejercicio5.monitoring.application.queries.GetSnapshotsByProductIdQuery;
import com.isa.platform.upc.Ejercicio5.monitoring.application.services.SnapshotCommandService;
import com.isa.platform.upc.Ejercicio5.monitoring.application.services.SnapshotQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Snapshot Controller", description = "Controller for managing snapshots")
@RestController
@RequestMapping("/api/v1/")
public class SnapshotController {
    @Autowired
    private final SnapshotQueryService snapshotQueryService;

    private final SnapshotCommandService snapshotCommandService;

    public SnapshotController(SnapshotQueryService snapshotQueryService, SnapshotCommandService snapshotCommandService) {
        this.snapshotQueryService = snapshotQueryService;
        this.snapshotCommandService = snapshotCommandService;
    }

    @Operation(summary = "Create a new snapshot for a product")
    @ApiResponse(responseCode = "201", description = "Snapshot created", content = @Content(mediaType = "application/json", schema=@Schema(implementation = SnapshotResponseDTO.class)))
    @ApiResponse(responseCode = "400", description = "Invalid snapshot data", content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "404", description = "Product not found", content = @Content(mediaType = "application/json"))
    @Transactional
    @PostMapping("/products/{productId}/snapshots")

    public ResponseEntity<SnapshotResponseDTO> createSnapshot(@PathVariable Long productId, @RequestBody SnapshotRequestDTO snapshotRequestDTO){
        CreateSnapshotCommand command = new CreateSnapshotCommand(productId, snapshotRequestDTO);
        SnapshotResponseDTO snapshotResponseDTO = snapshotCommandService.handle(command);
        return new ResponseEntity<>(snapshotResponseDTO, HttpStatus.CREATED);
    }

    @Operation(summary = "Get snapshots by product id", description = "Get snapshots by product id")
    @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(mediaType = "application/json", schema=@Schema(implementation = SnapshotResponseDTO.class)))
    @Transactional(readOnly = true)
    @GetMapping("/products/{productId}/snapshots")
    public List<SnapshotResponseDTO> getSnapshotsByProductId(@PathVariable Long productId){
        GetSnapshotsByProductIdQuery query = new GetSnapshotsByProductIdQuery(productId);
        return snapshotQueryService.handle(query);
    }

}
