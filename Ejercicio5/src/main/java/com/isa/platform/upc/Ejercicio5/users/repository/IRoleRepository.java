package com.isa.platform.upc.Ejercicio5.users.repository;


import com.isa.platform.upc.Ejercicio5.users.model.entity.Role;
import com.isa.platform.upc.Ejercicio5.users.model.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositorio de roles
 */
public interface IRoleRepository extends JpaRepository<Role, Long> {
    /**
     * Busca un rol por su nombre
     * @param name Nombre del rol
     * @return Rol encontrado (si existe)
     */
    Optional<Role> findByName(ERole name);

    /**
     * Verifica si existe un rol por su nombre
     * @param name Nombre del rol
     * @return true si existe, false si no
     */
    boolean existsByName(ERole name);
}
