package org.example.microservices.application.usecase;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.microservices.application.dto.command.CalculateOrderTotalValue;
import org.example.microservices.application.dto.result.ResultCalculatedOrderTotalValue;
import org.example.microservices.infra.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class CalculateTotalValueService implements CalculateTotalValueOrderUseCase {
    private final OrderRepository repository;


    @Override
    public ResultCalculatedOrderTotalValue execute(CalculateOrderTotalValue command) {
        var order = repository.getOrder(UUID.fromString(command.correlationId()))
                .orElseThrow(() -> new RuntimeException("Order not found."));
        order.calculateTotalValue(command.price());

        return new ResultCalculatedOrderTotalValue(
                order.getCorrelationId(),
                order.getTotalValue()
        );
    }
}
