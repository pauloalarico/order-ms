package org.example.microservices.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentReponseDto(
        UUID paymentId,
        UUID orderId,
        BigDecimal amount,
        String status
){
}
