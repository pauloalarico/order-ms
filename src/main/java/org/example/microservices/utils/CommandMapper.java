package org.example.microservices.utils;

import org.example.microservices.application.dto.command.CalculateOrderTotalValue;
import org.example.microservices.application.dto.command.SetOrderStatus;
import org.example.microservices.application.dto.shared.product.ListProductDto;
import org.example.microservices.application.dto.shared.response.PaymentReponseDto;

public class CommandMapper {

    public static CalculateOrderTotalValue listProductToCommand(ListProductDto dto) {
        return new CalculateOrderTotalValue(dto);
    }

    public static SetOrderStatus getPaymentStatus(PaymentReponseDto dto) {
        return new SetOrderStatus(dto);
    }
}
