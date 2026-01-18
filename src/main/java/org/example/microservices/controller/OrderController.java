package org.example.microservices.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.microservices.dto.request.RequestOrderDTO;
import org.example.microservices.dto.response.CompleteOrderDTO;
import org.example.microservices.http.ProductClient;
import org.example.microservices.service.OrderService;
import org.example.microservices.service.PaymentService;
import org.example.microservices.service.ProductService;
import org.example.microservices.utils.OrderMapperDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapperDTO mapperDto;
    private final ProductService productService;
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<CompleteOrderDTO> newOrder(@RequestBody @Valid RequestOrderDTO dto) {
        var order = orderService.createOrder(dto);
        var productDto = productService.decreaseStock(dto);
        orderService.calculateTotalValue(order, productDto.price(), order.getQuantity());
        var paymentProcess = paymentService.realizePayment(order.getOrderId(), (order.getTotalValue()));
        orderService.seeIfIsPaid(paymentProcess, order);
        return ResponseEntity.ok(mapperDto.createCompleteDto(order));
    }
}
