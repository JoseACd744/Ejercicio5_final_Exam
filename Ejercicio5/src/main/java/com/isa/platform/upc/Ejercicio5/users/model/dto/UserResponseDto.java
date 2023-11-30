package com.isa.platform.upc.Ejercicio5.users.model.dto;

import com.isa.platform.upc.Ejercicio5.users.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
/**
 * The UserResponseDto class is a Data Transfer Object (DTO) for user data response.
 * It is annotated with @Data, @AllArgsConstructor, and @NoArgsConstructor, which are Lombok annotations that automatically generate boilerplate code.
 *
 * @version 1.0
 * @author Jose Arenas Conde
 * @since 30/11/2023
 * @see com.isa.platform.upc.Ejercicio5.users.model.entity.Role
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    /**
     * Represents the user's ID.
     */
    private Long userId;

    /**
     * Represents the user's full name.
     */
    private String fullName;

    /**
     * Represents the user's username.
     */
    private String username;

    /**
     * Represents the user's email.
     */
    private String email;

    /**
     * Represents the roles assigned to the user.
     * It is a set of Role objects.
     */
    private Set<Role> roles = new HashSet<>();
}
