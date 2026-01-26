package org.example.microservices.application.dto.shared.response;

import java.time.ZonedDateTime;

public record CompleteOrderDTO(
        ZonedDateTime instant,
        OrderDTO[] orders
) {
    public CompleteOrderDTO(OrderDTO order) {
        this(ZonedDateTime.now(), new OrderDTO[] {order});
    }
}
