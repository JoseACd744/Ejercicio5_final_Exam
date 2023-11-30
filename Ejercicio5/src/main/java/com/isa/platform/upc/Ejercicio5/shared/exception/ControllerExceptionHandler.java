package com.isa.platform.upc.Ejercicio5.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

/**
 * Class that handles the exceptions thrown by the controllers.
 * @version 1.0, 1/12/2023
 * @author Jose Arenas Conde
 */

@RestControllerAdvice


public class ControllerExceptionHandler {

    /**
     * Method that handles the ResourceNotFoundException.
     * @param ex is the exception thrown by the controller.
     * @param request is the request.
     * @return ErrorMessage
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getDescription(false),
                LocalDateTime.now()
        );
        return message;
    }

    /**
     * Method that handles the ValidationException.
     * @param ex is the exception thrown by the controller.
     * @param request is the request.
     * @return ErrorMessage
     */
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage validationException(ValidationException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getDescription(false),
                LocalDateTime.now()
        );
        return message;
    }

    /**
     * Method that handles the Exception.
     * @param ex is the exception thrown by the controller.
     * @param request is the request.
     * @return ErrorMessage
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                request.getDescription(false),
                LocalDateTime.now()
        );
        return message;

    }
}
