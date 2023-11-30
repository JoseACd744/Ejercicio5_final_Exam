package com.isa.platform.upc.Ejercicio5.users.service;

import com.isa.platform.upc.Ejercicio5.shared.dto.response.ApiResponse;
import com.isa.platform.upc.Ejercicio5.users.model.dto.UserResponseDto;

/**
 * The IUserService interface provides methods for operations with users.
 *
 * @version 1.0
 * @author Jose Arenas Conde
 * @since 30/11/2023
 * @see com.isa.platform.upc.Ejercicio5.shared.dto.response.ApiResponse
 * @see com.isa.platform.upc.Ejercicio5.users.model.dto.UserResponseDto
 */
public interface IUserService {
    /**
     * This method is used to get the data of a user by their ID.
     *
     * @param userId The ID of the user.
     * @return An ApiResponse that contains the UserResponseDto if found, or empty if not.
     */
    ApiResponse<UserResponseDto> profile(Long userId);

    /**
     * This method is used to delete a user by their ID.
     *
     * @param userId The ID of the user.
     * @return An ApiResponse that contains the result of the operation.
     */
    ApiResponse<Object> deleteById(Long userId);
}