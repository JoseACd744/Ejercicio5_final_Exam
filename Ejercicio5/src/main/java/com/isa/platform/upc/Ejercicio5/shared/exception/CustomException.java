package com.isa.platform.upc.Ejercicio5.shared.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
/**
 * The CustomException class is used for handling other HTTP errors.
 * It extends RuntimeException, which means that it is an unchecked exception.
 * It is annotated with @Data, @AllArgsConstructor, @NoArgsConstructor, and @EqualsAndHashCode, which are Lombok annotations that automatically generate boilerplate code.
 *
 * @version 1.0
 * @author Jose Arenas Conde
 * @since 30/11/2023
 * @see org.springframework.http.HttpStatus
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException {
    /**
     * Represents the HTTP status of the error.
     */
    private HttpStatus status;

    /**
     * Constructor that initializes the CustomException with a status and a message.
     *
     * @param status The HTTP status of the error.
     * @param _message The detail message, saved for later retrieval by the Throwable.getMessage() method.
     */
    public CustomException(HttpStatus status, String _message) {
        super(_message);
        this.status = status;
    }
}