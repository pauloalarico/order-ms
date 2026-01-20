package org.example.microservices.service;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.example.microservices.dto.request.RequestOrderDTO;
import org.example.microservices.dto.response.ListReponsePaymentDto;
import org.example.microservices.entitie.Order;
import org.example.microservices.infra.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final ProductService productService;


    public Order createOrder(RequestOrderDTO dto) {
        var order = new Order(dto);
        return repository.save(order);
    }

    @Transactional
    public void calculateTotalValue(Order order, BigDecimal price, Integer quantity) {
        order.calculateTotalValue(price, quantity);
    }

    @Transactional
    public void seeIfIsPaid(ListReponsePaymentDto paymentDto, Order order, UUID uuid, Integer quantity) {
        var payment = paymentDto.payments().getFirst();
        if(payment.status().equals("REJECTED")) {
            order.cancelStatusOrder();
            productService.resetOrderProductStock(uuid, quantity);
        }
        if(payment.status().equals("APPROVED")) {
            order.paymentApproved();
        }
    }
}
