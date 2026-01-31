package org.example.microservices.utils;

import org.example.microservices.application.dto.command.CalculateOrderTotalValue;
import org.example.microservices.application.dto.command.SetOrderStatus;
import org.example.microservices.application.dto.result.ResultOrderCreated;
import org.example.microservices.application.dto.shared.product.ProductDto;
import org.example.microservices.application.dto.shared.response.PaymentReponseDto;
import org.example.microservices.model.entitie.Order;

import java.util.UUID;

public class CommandMapper {

    public static CalculateOrderTotalValue listProductToCommand(ProductDto dto) {
        return new CalculateOrderTotalValue(dto);
    }

    public static SetOrderStatus getPaymentStatus(PaymentReponseDto dto) {
        return new SetOrderStatus(dto);
    }

    public static ResultOrderCreated getProduct(Order order, UUID productId) {
        return new ResultOrderCreated(order, productId);
    }
    
}

