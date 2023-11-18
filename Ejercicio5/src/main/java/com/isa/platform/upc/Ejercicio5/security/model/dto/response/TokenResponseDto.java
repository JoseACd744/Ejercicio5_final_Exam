package com.isa.platform.upc.Ejercicio5.security.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa la respuesta de la API cuando se loguea un usuario y se le devuelve el token de acceso
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponseDto {
    private String token;
}
