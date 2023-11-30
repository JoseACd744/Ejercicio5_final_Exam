package com.isa.platform.upc.Ejercicio5.users.repository;

import com.isa.platform.upc.Ejercicio5.users.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The IUserRepository interface extends JpaRepository to perform persistence operations on the User entity.
 *
 * @version 1.0
 * @author Jose Arenas Conde
 * @since 30/11/2023
 * @see org.springframework.data.jpa.repository.JpaRepository
 * @see com.isa.platform.upc.Ejercicio5.users.model.entity.User
 */
public interface IUserRepository extends JpaRepository<User, Long> {
    /**
     * This method is used to find a user by their email or username.
     *
     * @param email The email of the user.
     * @param username The username of the user.
     * @return An Optional that contains the User if found, or empty if not.
     */
    Optional<User> findByEmailOrUsername(String email, String username);

    /**
     * This method is used to check if a user exists by their email.
     *
     * @param email The email of the user.
     * @return True if the user exists, false otherwise.
     */
    boolean existsByEmail(String email);

    /**
     * This method is used to check if a user exists by their username.
     *
     * @param username The username of the user.
     * @return True if the user exists, false otherwise.
     */
    boolean existsByUsername(String username);
}