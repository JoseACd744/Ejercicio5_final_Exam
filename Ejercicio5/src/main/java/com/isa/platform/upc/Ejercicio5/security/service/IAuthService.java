package com.isa.platform.upc.Ejercicio5.security.service;

import com.isa.platform.upc.Ejercicio5.security.model.dto.request.LoginRequestDto;
import com.isa.platform.upc.Ejercicio5.security.model.dto.request.RegisterRequestDto;
import com.isa.platform.upc.Ejercicio5.security.model.dto.response.RegisteredUserResponseDto;
import com.isa.platform.upc.Ejercicio5.security.model.dto.response.TokenResponseDto;
import com.isa.platform.upc.Ejercicio5.shared.dto.response.ApiResponse;

/**
 * Servicio para autenticación y registro de usuarios
 * @author Jamutaq Ortega
 */
public interface IAuthService {
    /**
     * Registra un usuario
     * @param request Datos para el registro
     * @return Usuario registrado
     */
    ApiResponse<RegisteredUserResponseDto> registerUser(RegisterRequestDto request);

    /**
     * Realiza el login del usuario
     * @param request Credenciales
     * @return Token de acceso
     */
    ApiResponse<TokenResponseDto> login(LoginRequestDto request);
}
