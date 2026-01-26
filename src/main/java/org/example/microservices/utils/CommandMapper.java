package org.example.microservices.utils;

import org.example.microservices.application.dto.command.CalculateOrderTotalValue;
import org.example.microservices.application.dto.command.SetOrderStatus;
import org.example.microservices.application.dto.result.ResultOrderCreated;
import org.example.microservices.application.dto.shared.product.ListProductDto;
import org.example.microservices.application.dto.shared.response.PaymentReponseDto;
import org.example.microservices.domain.entitie.Order;

public class CommandMapper {

    public static CalculateOrderTotalValue listProductToCommand(ListProductDto dto) {
        return new CalculateOrderTotalValue(dto);
    }

    public static SetOrderStatus getPaymentStatus(PaymentReponseDto dto) {
        return new SetOrderStatus(dto);
    }

    public static ResultOrderCreated getProduct(Order order) {
        return new ResultOrderCreated(order);
    }
    
}

