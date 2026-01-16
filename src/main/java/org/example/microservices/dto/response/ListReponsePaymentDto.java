package org.example.microservices.dto.response;

import java.util.List;

public record ListReponsePaymentDto (
        List<ListReponsePaymentDto> payments
){
}
