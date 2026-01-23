package org.example.microservices.application.dto.response;

import java.util.List;

public record ListReponsePaymentDto (
        List<PaymentReponseDto> payments
){
}
