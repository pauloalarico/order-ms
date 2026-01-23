package org.example.microservices.utils;

import org.example.microservices.application.dto.request.DecreaseStockDto;
import org.springframework.stereotype.Component;

@Component
public class ProductDtoMapper {

    public DecreaseStockDto decreaseStockMapper(Integer quantity) {
        return new DecreaseStockDto(quantity);
    }
}
