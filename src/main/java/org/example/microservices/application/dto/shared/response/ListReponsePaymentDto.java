package org.example.microservices.application.dto.shared.response;

import java.util.List;

public record ListReponsePaymentDto (
        List<PaymentReponseDto> payments
){
}
