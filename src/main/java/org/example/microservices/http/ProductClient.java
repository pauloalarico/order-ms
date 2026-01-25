package org.example.microservices.http;

import org.example.microservices.infra.configuration.FeignClientConfig;
import org.example.microservices.application.dto.request.DecreaseStockDto;
import org.example.microservices.application.dto.json.product.ListProductDto;
import org.example.microservices.application.dto.json.product.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

@FeignClient(value = "product-microsservice", configuration = FeignClientConfig.class)
public interface ProductClient {
    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    ProductDto verifyProduct(@PathVariable String id);

    @RequestMapping(method = RequestMethod.PUT, value  = "/products/{id}/decrease-stock")
    ListProductDto decreaseStock(@PathVariable UUID id, @RequestBody DecreaseStockDto dto);

    @RequestMapping(method = RequestMethod.PUT, value ="/{id}/reset-stock/{quantity}")
    void resetProductQuantityByOrder(@PathVariable UUID id, @PathVariable Integer quantity);
}
