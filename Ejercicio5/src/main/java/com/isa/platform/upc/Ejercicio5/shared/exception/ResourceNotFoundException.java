package com.isa.platform.upc.Ejercicio5.shared.exception;

/**
 * Class that represents the ResourceNotFoundException.
 * @version 1.0, 08/11/2023
 * @autor Jose Arenas Conde
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super();
    }
    /**
     * Constructor of the ResourceNotFoundException.
     * @param message is the message of the exception.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

}