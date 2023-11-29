package com.isa.platform.upc.Ejercicio5.inventory.application.queries;

public class GetProductByIdQuery {
    private final Long productId;

    public GetProductByIdQuery(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }
}
