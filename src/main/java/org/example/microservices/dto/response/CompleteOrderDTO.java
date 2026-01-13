package org.example.microservices.dto.response;

import java.time.ZonedDateTime;

public record CompleteOrderDTO(
        ZonedDateTime instant,
        OrderDTO[] orders
) {
    public CompleteOrderDTO(OrderDTO order) {
        this(ZonedDateTime.now(), new OrderDTO[] {order});
    }
}
