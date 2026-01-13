package org.example.microservices.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.microservices.dto.request.RequestOrderDTO;
import org.example.microservices.dto.response.CompleteOrderDTO;
import org.example.microservices.service.OrderService;
import org.example.microservices.utils.OrderMapperDTO;
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

    @PostMapping
    public ResponseEntity<CompleteOrderDTO> newOrder(@RequestBody @Valid RequestOrderDTO dto) {
        var order = orderService.createOrder(dto);
        return ResponseEntity.ok(mapperDto.createCompleteDto(order));
    }
}
