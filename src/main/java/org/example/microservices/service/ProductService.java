package org.example.microservices.service;

import lombok.RequiredArgsConstructor;
import org.example.microservices.dto.request.RequestOrderDTO;
import org.example.microservices.http.ProductClient;
import org.example.microservices.json.product.ProductDto;
import org.example.microservices.utils.ProductDtoMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductClient productClient;
    private final ProductDtoMapper mapper;

    public ProductDto verifyProduct(RequestOrderDTO dto) {
        var productDto = productClient.verifyProduct(String.valueOf(dto.productId()));
        if(productDto.id() == null) {
            throw new RuntimeException("Product not found, or does not exists.");
        }
        return decreaseStock(String.valueOf(dto.productId()), dto.quantity());
    }

    private ProductDto decreaseStock(String id, Integer quantity) {
        var requestBodyDto = mapper.decreaseStockMapper(quantity);
        return productClient.decreaseStock(id, requestBodyDto);
    }
}
