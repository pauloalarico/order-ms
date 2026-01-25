package org.example.microservices.application.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentReponseDto(
        UUID paymentId,
        UUID correlationId,
        BigDecimal amount,
        String status
){
}
