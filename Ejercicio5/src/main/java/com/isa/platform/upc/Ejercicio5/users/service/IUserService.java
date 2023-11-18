package com.isa.platform.upc.Ejercicio5.users.service;

import com.isa.platform.upc.Ejercicio5.shared.dto.response.ApiResponse;
import com.isa.platform.upc.Ejercicio5.users.model.dto.UserResponseDto;


/**
 * Servicio para operaciones con usuarios
 */
public interface IUserService {
    /**
     * Obtiene los datos de un usuario por su id
     * @param userId id del usuario
     * @return Datos del usuario
     */
    ApiResponse<UserResponseDto> profile(Long userId);

    /**
     * Elimina un usuario por su id
     * @param userId id del usuario
     * @return Respuesta de la operación
     */
    ApiResponse<Object> deleteById(Long userId);
}
