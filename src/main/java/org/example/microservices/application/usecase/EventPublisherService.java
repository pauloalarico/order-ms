package org.example.microservices.application.usecase;

import lombok.RequiredArgsConstructor;
import org.example.microservices.application.dto.result.ResultCalculatedOrderTotalValue;
import org.example.microservices.application.dto.result.ResultQuantityToRestock;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventPublisherService implements OrderEventCreatedPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final static String PAYMENT_CREATED_EX = "payment-created.ex";
    private final static String PRODUCT_RESTOCK_EX = "restock-product.ex";

    @Override
    public void publish(ResultCalculatedOrderTotalValue result) {
        rabbitTemplate.convertAndSend(PAYMENT_CREATED_EX, "", result);
    }

    @Override
    public void publish(ResultQuantityToRestock result) {
        rabbitTemplate.convertAndSend(PRODUCT_RESTOCK_EX, "", result);
    }
}
