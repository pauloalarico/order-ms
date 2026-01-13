package org.example.microservices.service;

import lombok.RequiredArgsConstructor;
import org.example.microservices.dto.request.RequestOrderDTO;
import org.example.microservices.entitie.Order;
import org.example.microservices.infra.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;


    public Order createOrder(RequestOrderDTO dto) {
        var order = new Order(dto);
        return repository.save(order);
    }
}
