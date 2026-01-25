package org.example.microservices.application.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.microservices.application.dto.request.RequestOrderDTO;
import org.example.microservices.application.dto.response.PaymentReponseDto;
import org.example.microservices.domain.entitie.Order;
import org.example.microservices.infra.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final ProductService productService;
    private final RabbitPublisherService publisher;


    public void verifyProduct(UUID correlationId, RequestOrderDTO dto) {
        publisher.verifyProduct(correlationId, dto);
    }


    public Order createOrder(RequestOrderDTO dto) {
        var order = new Order(dto);
        return repository.save(order);
    }

    @Transactional
    public void calculateTotalValue(Order order, BigDecimal price, Integer quantity) {
        order.calculateTotalValue(price, quantity);
        repository.save(order);
    }

    @Transactional
    public void seeIfIsPaid(PaymentReponseDto payment) {
        var order = getOrderByCorrelationId(payment.correlationId().toString());
        if(payment.status().equals("REJECTED")) {
            order.cancelStatusOrder();
            publisher.resetStockByOrder(order.getCorrelationId(), order.getProductId(), order.getQuantity());
            //productService.resetOrderProductStock(uuid, quantity);
        }
        if(payment.status().equals("APPROVED")) {
            order.paymentApproved();
        }
    }

    public Order getOrderByCorrelationId(String correlationId) {
        return repository.getOrder(UUID.fromString(correlationId)).orElseThrow(()
                -> new RuntimeException("Order not found or does not exist."));
    }
}
