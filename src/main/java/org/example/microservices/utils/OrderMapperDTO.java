package org.example.microservices.utils;

import org.example.microservices.dto.response.CompleteOrderDTO;
import org.example.microservices.dto.response.OrderDTO;
import org.example.microservices.entitie.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperDTO {
    public CompleteOrderDTO createCompleteDto(Order order) {
        var orderDto = new OrderDTO(order);
        return new CompleteOrderDTO(orderDto);
    }

    public OrderDTO createOrderDto(Order order) {
        return new OrderDTO(order);
    }
}
