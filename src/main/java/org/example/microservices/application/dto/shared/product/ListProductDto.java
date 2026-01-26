package org.example.microservices.application.dto.shared.product;

import java.util.List;

public record ListProductDto (
        List<ProductDto> products
){
}
