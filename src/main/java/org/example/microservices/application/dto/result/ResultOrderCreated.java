package org.example.microservices.application.dto.result;

import org.example.microservices.domain.entitie.Order;

import java.util.UUID;

public record ResultOrderCreated(
        UUID correlationId,
        UUID id,
        Integer quantity
) {
    public ResultOrderCreated(Order order) {
        this(order.getCorrelationId(), order.getOrderId(), order.getQuantity());
    }
}
