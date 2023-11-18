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
 * Servicio para usuarios
 */
@Service
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(IUserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse<UserResponseDto> profile(Long userId) {
       var user = userRepository.findById(userId)
               .orElseThrow(() -> new ResourceNotFoundException("No se encontró el usuario con id " + userId));

       //se mapea el usuario a un DTO
       var userDto = modelMapper.map(user, UserResponseDto.class);

       return new ApiResponse<>("Usuario encontrado", EStatus.SUCCESS, userDto);
    }

    @Override
    public ApiResponse<Object> deleteById(Long userId) {
        var user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el usuario con id " + userId));

        //elimina al usuario
        userRepository.delete(user);

        return new ApiResponse<>("Usuario eliminado correctamente", EStatus.SUCCESS, null);
    }
}
