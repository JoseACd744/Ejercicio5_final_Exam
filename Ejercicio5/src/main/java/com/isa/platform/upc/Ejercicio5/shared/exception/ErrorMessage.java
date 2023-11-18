package com.isa.platform.upc.Ejercicio5.shared.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Class that represents the error message.
 * This class is used to return the error message to the client.
 * @version 1.0, 08/11/2023
 * <p>
 *  *   The annotations used here are:
 *  *  <ul>
 *  *      <li>{@code @Data} - Lombok annotation for automatically generating repetitive code: getters, setters, equals, hashCode, and the toString method.</li>
 *  *      <li>{@code @NoArgsConstructor} - Lombok annotation to generate a no-argument constructor.</li>
 *  *      <li>{@code @AllArgsConstructor} - Lombok annotation to generate an argument constructor for all fields.</li>
 *  *  </ul>
 *  * @author Jose Arenas Conde - u20211d744
 *  * </p>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    /**
     * The status code of the error.
     */
    private int statusCode;
    /**
     * The message of the error.
     */
    private String message;
    /**
     * The description of the error.
     */
    private String description;
    /**
     * The timestamp of the error.
     * It is formatted as dd-MM-yyyy hh:mm:ss.
     * @see JsonFormat
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
}
