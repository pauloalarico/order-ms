package org.example.microservices.application.service;

import lombok.RequiredArgsConstructor;
import org.example.microservices.application.dto.json.product.ProductSenderDTO;
import org.example.microservices.application.dto.request.RequestOrderDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RabbitPublisherService {

    private final RabbitTemplate rabbitTemplate;

    public void verifyProduct(UUID correlationId, RequestOrderDTO dto) {
        var productId = new ProductSenderDTO(correlationId, dto.productId(), dto.quantity());
        rabbitTemplate.convertAndSend("order-created.ex", "", productId);
    }

}
