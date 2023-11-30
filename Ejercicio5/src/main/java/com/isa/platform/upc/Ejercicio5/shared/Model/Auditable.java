package com.isa.platform.upc.Ejercicio5.shared.Model;

import java.util.Date;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * The Auditable class is an abstract class that provides auditing information for an entity.
 * It is annotated with @MappedSuperclass, which means that it is not an entity itself, but its fields will be mapped to the database in entities that extend it.
 * It is also annotated with @EntityListeners(AuditingEntityListener.class), which means that it will listen for auditing events.
 *
 * @version 1.0
 * @author Jose Arenas Conde
 * @since 30/11/2023
 * @see jakarta.persistence.MappedSuperclass
 * @see jakarta.persistence.EntityListeners
 * @see org.springframework.data.jpa.domain.support.AuditingEntityListener
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {

    /**
     * Represents the creation date and time of the entity.
     * It is annotated with @CreatedDate, which means that it will be set when the entity is created.
     * It is also annotated with @Temporal(TemporalType.TIMESTAMP), which means that it will be stored in the database as a timestamp.
     *
     * @see org.springframework.data.annotation.CreatedDate
     * @see jakarta.persistence.Temporal
     */
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date creationDateTime;

    /**
     * Represents the last update date and time of the entity.
     * It is annotated with @LastModifiedDate, which means that it will be set when the entity is updated.
     * It is also annotated with @Temporal(TemporalType.TIMESTAMP), which means that it will be stored in the database as a timestamp.
     *
     * @see org.springframework.data.annotation.LastModifiedDate
     * @see jakarta.persistence.Temporal
     */
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastUpdateDateTime;
}
