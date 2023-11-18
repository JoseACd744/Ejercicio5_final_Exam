package com.isa.platform.upc.Ejercicio5.shared.dto.response;

import com.isa.platform.upc.Ejercicio5.shared.dto.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase que representa la respuesta de la API
 * @param <T> Tipo de dato que se retornará en la respuesta
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private String message;
    private EStatus status;
    private T data;
}
