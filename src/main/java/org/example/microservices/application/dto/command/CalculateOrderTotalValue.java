package org.example.microservices.application.dto.command;

import org.example.microservices.application.dto.shared.product.ListProductDto;

import java.math.BigDecimal;

public record CalculateOrderTotalValue(
        String correlationId,
        BigDecimal price
) {
    public CalculateOrderTotalValue(ListProductDto dto) {
        this(dto.products().getFirst().correlationId(), dto.products().getFirst().price());
    }
}
