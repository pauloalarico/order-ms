package org.example.microservices.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.microservices.application.dto.json.payment.NewPaymentDto;
import org.example.microservices.application.dto.json.product.ListProductDto;
import org.example.microservices.application.dto.json.product.ProductDto;
import org.example.microservices.application.dto.response.PaymentReponseDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitServiceListener {
    private final OrderService orderService;
    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "products-decreased.queue")
    public void calculateTotalValue(ListProductDto dto) {
        var order = orderService.getOrderByCorrelationId(dto.products().getFirst().correlationId());
        orderService.calculateTotalValue(order, dto.products().getFirst().price(), order.getQuantity());
        log.info("Price for Order id: {} calculated, total: {}", order.getOrderId(), order.getTotalValue());
        rabbitTemplate.convertAndSend("payment-created.ex", "", new NewPaymentDto(order.getCorrelationId(), order.getTotalValue()));
    }

    @RabbitListener(queues = "orders-payed.queue")
    public void setOrderStatus(PaymentReponseDto paymentDto) {
        orderService.seeIfIsPaid(paymentDto);
    }
}
