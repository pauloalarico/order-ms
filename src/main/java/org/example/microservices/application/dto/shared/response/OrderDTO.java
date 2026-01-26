package org.example.microservices.application.dto.shared.response;

import org.example.microservices.domain.entitie.Order;
import org.example.microservices.domain.enums.StatusOrder;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderDTO(
        UUID orderId,
        UUID productId,
        Integer quantity,
        BigDecimal totalValue,
        StatusOrder status
) {
    public OrderDTO(Order order) {
        this(order.getOrderId(), order.getProductId(), order.getQuantity(),
                order.getTotalValue(), order.getStatusOrder());
    }
}
