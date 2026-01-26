package org.example.microservices.presentation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.microservices.application.dto.shared.request.RequestOrderDTO;
import org.example.microservices.application.dto.shared.response.CompleteOrderDTO;
import org.example.microservices.application.service.OrderService;
import org.example.microservices.utils.OrderMapperDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapperDTO mapperDto;

    @PostMapping
    public ResponseEntity<CompleteOrderDTO> newOrder(@RequestBody @Valid RequestOrderDTO dto) {
        var order = orderService.createOrder(dto);
        orderService.verifyProduct(order.getCorrelationId(), dto);
        return ResponseEntity.ok(mapperDto.createCompleteDto(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompleteOrderDTO> getOrder(@PathVariable String id) {
        var order = orderService.getOrderByOrderId(id);
        return ResponseEntity.ok(mapperDto.createCompleteDto(order));
    }
}
