package org.example.microservices.utils;

import org.example.microservices.dto.request.RealizePaymentDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class PaymentMapperDto {
    public RealizePaymentDto requestDto(UUID uuid, BigDecimal amount) {
        return new RealizePaymentDto(uuid, amount);
    }
}
