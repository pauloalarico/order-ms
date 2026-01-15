package org.example.microservices.service;

import lombok.RequiredArgsConstructor;
import org.example.microservices.http.PaymentClient;
import org.example.microservices.utils.PaymentMapperDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentClient paymentClient;
    private final PaymentMapperDto mapperPayment;

    public void realizePayment(UUID orderId, BigDecimal amount){
        var dtoRequest = mapperPayment.requestDto(orderId, amount);
    }
}
