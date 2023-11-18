package com.isa.platform.upc.Ejercicio5.security.controller;


import com.isa.platform.upc.Ejercicio5.security.model.dto.request.LoginRequestDto;
import com.isa.platform.upc.Ejercicio5.security.model.dto.request.RegisterRequestDto;
import com.isa.platform.upc.Ejercicio5.security.model.dto.response.RegisteredUserResponseDto;
import com.isa.platform.upc.Ejercicio5.security.model.dto.response.TokenResponseDto;
import com.isa.platform.upc.Ejercicio5.security.service.AuthService;
import com.isa.platform.upc.Ejercicio5.security.service.IAuthService;
import com.isa.platform.upc.Ejercicio5.shared.dto.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para autenticación y registro de usuarios
 */
@Tag(name = "Auth")
@SecurityRequirements //desactiva la seguridad para este controlador (swagger)
@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {
    private final IAuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    /**
     * Inicia sesión
     * @param request Datos para iniciar sesión
     * @return Token de acceso
     */
    @Operation(summary = "Inicia sesión")
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<TokenResponseDto>> login(@Valid @RequestBody LoginRequestDto request) {
        var res = service.login(request);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    /**
     * Registra un nuevo usuario
     * @param request Datos para el registro
     */
    @Operation(summary = "Registra un nuevo usuario")
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<RegisteredUserResponseDto>> registerUser(@Valid @RequestBody RegisterRequestDto request) {
        var res = service.registerUser(request);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}
