package org.example.microservices.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.microservices.application.dto.json.product.ProductSenderDTO;
import org.example.microservices.application.dto.request.RequestOrderDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitPublisherService {

    private final RabbitTemplate rabbitTemplate;

    public void verifyProduct(UUID correlationId, RequestOrderDTO dto) {
        var productId = new ProductSenderDTO(correlationId, dto.productId(), dto.quantity());
        rabbitTemplate.convertAndSend("order-created.ex", "", productId);
    }

    public void resetStockByOrder(UUID correlationId, UUID productId, Integer quantity) {
        var productRequest = new ProductSenderDTO(correlationId, productId, quantity);
        rabbitTemplate.convertAndSend("payment-created.ex", "", productRequest);
        log.info("Order CANCELED, correlationId: {}, productId: {}, quantity: {}", correlationId, productId, quantity);
    }
}
