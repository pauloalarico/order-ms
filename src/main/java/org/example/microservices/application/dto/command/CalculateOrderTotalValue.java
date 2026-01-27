package org.example.microservices.application.dto.command;

import org.example.microservices.application.dto.shared.product.ProductDto;

import java.math.BigDecimal;

public record CalculateOrderTotalValue(
        String correlationId,
        BigDecimal price
) {
    public CalculateOrderTotalValue(ProductDto dto) {
        this(dto.correlationId(), dto.price());
    }
}
