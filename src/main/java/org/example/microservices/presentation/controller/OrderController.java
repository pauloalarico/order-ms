package org.example.microservices.presentation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.microservices.application.dto.request.RequestOrderDTO;
import org.example.microservices.application.dto.response.CompleteOrderDTO;
import org.example.microservices.application.service.OrderService;
import org.example.microservices.application.service.PaymentService;
import org.example.microservices.application.service.ProductService;
import org.example.microservices.utils.OrderMapperDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapperDTO mapperDto;
    private final ProductService productService;
    private final PaymentService paymentService;
    private final RabbitTemplate rabbitTemplate;

    @PostMapping
    public ResponseEntity<CompleteOrderDTO> newOrder(@RequestBody @Valid RequestOrderDTO dto) {
        var order = orderService.createOrder(dto);
        productService.verifyIfProductExists(dto.productId());
        var productDto = productService.decreaseStock(dto);
        orderService.calculateTotalValue(order, productDto.price(), order.getQuantity());
        var paymentProcess = paymentService.realizePayment(order.getOrderId(), (order.getTotalValue()));
        orderService.seeIfIsPaid(paymentProcess, order, dto.productId(), dto.quantity());
        return ResponseEntity.ok(mapperDto.createCompleteDto(order));
    }
}
