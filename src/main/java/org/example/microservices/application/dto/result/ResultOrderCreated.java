package org.example.microservices.application.dto.result;

import org.example.microservices.model.entitie.Order;

import java.util.UUID;

public record ResultOrderCreated(
        UUID correlationId,
        UUID id,
        Integer quantity
) {
    public ResultOrderCreated(Order order, UUID productId) {
        this(order.getCorrelationId(), order.getProductId(), order.getQuantity());
    }
}
