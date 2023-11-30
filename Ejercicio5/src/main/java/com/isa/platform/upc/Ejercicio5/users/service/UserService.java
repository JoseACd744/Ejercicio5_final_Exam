package com.isa.platform.upc.Ejercicio5.users.service;

import com.isa.platform.upc.Ejercicio5.shared.dto.enums.EStatus;
import com.isa.platform.upc.Ejercicio5.users.model.dto.UserResponseDto;
import com.isa.platform.upc.Ejercicio5.users.model.entity.User;
import com.isa.platform.upc.Ejercicio5.users.repository.IUserRepository;
import com.isa.platform.upc.Ejercicio5.shared.dto.response.ApiResponse;
import com.isa.platform.upc.Ejercicio5.shared.exception.ResourceNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * The UserService class provides services for users.
 * It implements the IUserService interface.
 *
 * @version 1.0
 * @author Jose Arenas Conde
 * @since 30/11/2023
 * @see com.isa.platform.upc.Ejercicio5.users.service.IUserService
 */
@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final ModelMapper modelMapper;

    /**
     * Constructor that initializes the UserService with a userRepository and a modelMapper.
     *
     * @param userRepository The userRepository to use.
     * @param modelMapper The modelMapper to use.
     */
    public UserService(IUserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * This method is used to get the profile of a user by their ID.
     * It throws a ResourceNotFoundException if the user is not found.
     *
     * @param userId The ID of the user.
     * @return An ApiResponse that contains the UserResponseDto if found, or empty if not.
     * @throws ResourceNotFoundException if the user is not found.
     */
    @Override
    public ApiResponse<UserResponseDto> profile(Long userId) {
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el usuario con id " + userId));

        var userDto = modelMapper.map(user, UserResponseDto.class);

        return new ApiResponse<>("Usuario encontrado", EStatus.SUCCESS, userDto);
    }

    /**
     * This method is used to delete a user by their ID.
     * It throws a ResourceNotFoundException if the user is not found.
     *
     * @param userId The ID of the user.
     * @return An ApiResponse that contains the result of the operation.
     * @throws ResourceNotFoundException if the user is not found.
     */
    @Override
    public ApiResponse<Object> deleteById(Long userId) {
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el usuario con id " + userId));

        userRepository.delete(user);

        return new ApiResponse<>("Usuario eliminado correctamente", EStatus.SUCCESS, null);
    }
}