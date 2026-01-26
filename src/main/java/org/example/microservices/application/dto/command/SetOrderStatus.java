package org.example.microservices.application.dto.command;

import org.example.microservices.application.dto.shared.response.PaymentReponseDto;

import java.math.BigDecimal;
import java.util.UUID;

public record SetOrderStatus (
        UUID correlationId,
        BigDecimal amount,
        String status
) {
    public SetOrderStatus(PaymentReponseDto dto) {
        this(dto.correlationId(), dto.amount(), dto.status());
    }
}
