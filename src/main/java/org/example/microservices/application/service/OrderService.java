package org.example.microservices.application.service;

import lombok.RequiredArgsConstructor;
import org.example.microservices.application.dto.command.RequestOrderDTO;
import org.example.microservices.domain.entitie.Order;
import org.example.microservices.infra.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public Order getOrderByOrderId(String orderId) {
        return repository.getOrderByOrderId(orderId).orElseThrow(() -> new RuntimeException(
                "Order not found")
        );
    }
}
