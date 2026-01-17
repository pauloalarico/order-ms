package org.example.microservices.json.product;

import java.util.List;

public record ListProductDto (
        List<ProductDto> products
){
}
