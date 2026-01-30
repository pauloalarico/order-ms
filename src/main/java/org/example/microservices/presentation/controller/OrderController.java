package org.example.microservices.presentation.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.microservices.application.dto.command.RequestOrderDTO;
import org.example.microservices.application.dto.shared.response.CompleteOrderDTO;
import org.example.microservices.application.usecase.create.CreateNewOrderUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final CreateNewOrderUseCase createOrder;

    @PostMapping
    public ResponseEntity<CompleteOrderDTO> newOrder(@RequestBody @Valid RequestOrderDTO dto) {
        var order = createOrder.create(dto);
        return ResponseEntity.ok(order);
    }
}
