package com.isa.platform.upc.Ejercicio5.shared.dto.response;

import com.isa.platform.upc.Ejercicio5.shared.dto.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * The ApiResponse class is used for representing the response of the API.
 * It is a generic class, where T represents the type of data that will be returned in the response.
 *
 * @param <T> The type of data that will be returned in the response.
 * @version 1.0
 * @author Jose Arenas Conde
 * @since 30/11/2023
 * @see com.isa.platform.upc.Ejercicio5.shared.dto.enums.EStatus
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    /**
     * Represents the message of the response.
     */
    private String message;

    /**
     * Represents the status of the response.
     * It is an enum with two possible values: SUCCESS and ERROR.
     */
    private EStatus status;

    /**
     * Represents the data of the response.
     * It is of type T, which is a generic type.
     */
    private T data;
}
