package org.example.microservices.infra.messaging.rabbitmq.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.microservices.application.dto.shared.product.ListProductDto;
import org.example.microservices.application.dto.shared.product.ProductDto;
import org.example.microservices.application.dto.shared.response.PaymentReponseDto;
import org.example.microservices.application.usecase.value.CalculateTotalValueOrderUseCase;
import org.example.microservices.application.usecase.OrderEventCreatedPublisher;
import org.example.microservices.application.usecase.update.UpdateStatusPaymentUseCase;
import org.example.microservices.utils.CommandMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitServiceListener {
    private final CalculateTotalValueOrderUseCase calculate;
    private final UpdateStatusPaymentUseCase update;
    private final OrderEventCreatedPublisher publisher;


    @RabbitListener(queues = "products-decreased.queue")
    public void calculateTotalValue(ProductDto dto) {
        var mapper = CommandMapper.listProductToCommand(dto);
        var result = calculate.execute(mapper);
        publisher.publish(result);
    }

    @RabbitListener(queues = "orders-payed.queue")
    public void setOrderStatus(PaymentReponseDto paymentDto) {
        var mapper = CommandMapper.getPaymentStatus(paymentDto);
        var result = update.update(mapper);
        if (result != null) {
            publisher.publish(result);
        }
    }
}
