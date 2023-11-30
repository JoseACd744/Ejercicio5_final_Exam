package com.isa.platform.upc.Ejercicio5.users.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
/**
 * The User class is an entity that represents a user of the application.
 * It is annotated with @Data, @AllArgsConstructor, @NoArgsConstructor, and @Builder, which are Lombok annotations that automatically generate boilerplate code.
 * It is also annotated with @Entity and @Table(name = "users"), which are JPA annotations that indicate this class is a JPA entity and map it to the "users" table in the database.
 *
 * @version 1.0
 * @author Jose Arenas Conde
 * @since 30/11/2023
 * @see jakarta.persistence.Entity
 * @see jakarta.persistence.Table
 * @see com.isa.platform.upc.Ejercicio5.users.model.entity.Role
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    /**
     * Represents the ID of the user.
     * It is annotated with @Id and @GeneratedValue(strategy = GenerationType.IDENTITY), which are JPA annotations that indicate this field is the primary key and is generated automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    /**
     * Represents the full name of the user.
     * It is annotated with @Column(nullable = false), which means that this field cannot be null in the database.
     */
    @Column(nullable = false)
    private String fullName;

    /**
     * Represents the username of the user.
     * It is unique and cannot be null in the database.
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * Represents the email of the user.
     * It is unique and cannot be null in the database.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Represents the password of the user.
     * It cannot be null in the database.
     */
    @Column(nullable = false)
    private String password;

    /**
     * Represents the roles assigned to the user.
     * It is a set of Role objects.
     * It is annotated with @ManyToMany, @JoinTable, and @JoinColumn, which are JPA annotations that indicate this field is a many-to-many relationship with the Role entity and map it to the "users_roles" join table in the database.
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    )
    private Set<Role> roles = new HashSet<>();
}
