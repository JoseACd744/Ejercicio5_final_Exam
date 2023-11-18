package com.isa.platform.upc.Ejercicio5.shared.exception;

/**
 * Class that represents the ValidationException.
 * @version 1.0, 08/11/2023
 * @autor Jose Arenas Conde
 */
public class ValidationException extends RuntimeException{
    public ValidationException() {
        super();
    }

    /**
     * Constructor of the ValidationException.
     * @param message is the message of the exception.
     */
    public ValidationException(String message) {
        super(message);
    }
}
