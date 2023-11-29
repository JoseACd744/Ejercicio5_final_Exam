package com.isa.platform.upc.Ejercicio5.inventory.application.services;

import com.isa.platform.upc.Ejercicio5.inventory.application.dtos.ProductResponseDTO;
import com.isa.platform.upc.Ejercicio5.inventory.application.queries.GetProductByIdQuery;

public interface ProductQueryService {
    ProductResponseDTO handle(GetProductByIdQuery query);

}
