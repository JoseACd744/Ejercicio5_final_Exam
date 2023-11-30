package com.isa.platform.upc.Ejercicio5.users.model.entity;

import com.isa.platform.upc.Ejercicio5.users.model.enums.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Role class is an entity that represents user roles.
 * It is annotated with @Data, @AllArgsConstructor, and @NoArgsConstructor, which are Lombok annotations that automatically generate boilerplate code.
 * It is also annotated with @Entity and @Table(name = "roles"), which are JPA annotations that indicate this class is a JPA entity and map it to the "roles" table in the database.
 *
 * @version 1.0
 * @author Jose Arenas Conde
 * @since 30/11/2023
 * @see com.isa.platform.upc.Ejercicio5.users.model.enums.ERole
 * @see jakarta.persistence.Entity
 * @see jakarta.persistence.Table
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    /**
     * Represents the ID of the role.
     * It is annotated with @Id and @GeneratedValue(strategy = GenerationType.IDENTITY), which are JPA annotations that indicate this field is the primary key and is generated automatically.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    /**
     * Represents the name of the role.
     * It is an enum with possible values defined in ERole.
     * It is annotated with @Enumerated(EnumType.STRING), which means that the enum values will be stored as strings in the database.
     * It is also annotated with @Column(nullable = false), which means that this field cannot be null in the database.
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ERole name;
}
