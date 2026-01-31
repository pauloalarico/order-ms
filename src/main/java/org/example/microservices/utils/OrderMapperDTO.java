package org.example.microservices.utils;

import org.example.microservices.application.dto.shared.response.CompleteOrderDTO;
import org.example.microservices.application.dto.shared.response.OrderDTO;
import org.example.microservices.model.entitie.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapperDTO {
    public static CompleteOrderDTO createCompleteDto(Order order) {
        var orderDto = new OrderDTO(order);
        return new CompleteOrderDTO(orderDto);
    }

    public static OrderDTO createOrderDto(Order order) {
        return new OrderDTO(order);
    }
}

