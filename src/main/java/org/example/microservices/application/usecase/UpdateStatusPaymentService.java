package org.example.microservices.application.usecase;

import lombok.RequiredArgsConstructor;
import org.example.microservices.application.dto.command.SetOrderStatus;
import org.example.microservices.application.dto.result.ResultQuantityToRestock;
import org.example.microservices.infra.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateStatusPaymentService implements UpdateStatusPaymentUseCase {
    private final OrderRepository repository;


    @Override
    public ResultQuantityToRestock update(SetOrderStatus command) {
        var order = repository.getOrder(command.correlationId()).orElseThrow(()
                -> new RuntimeException("Order not found"));

        if(command.status().equals("REJECTED")) {
            order.cancelStatusOrder();
            return new ResultQuantityToRestock(
                    order.getCorrelationId(),
                    order.getQuantity()
            );
        }
        if(command.status().equals("APPROVED")) {
            order.paymentApproved();
        }
        return null;
    }
}
