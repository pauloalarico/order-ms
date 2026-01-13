package org.example.microservices.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("product-microsservice")
public interface ProductClient {
    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    String verifyProduct(@PathVariable String id);

    @RequestMapping(method = RequestMethod.PUT, value  = "/products/{id}/decrease-stock")
    String decreaseStock(@PathVariable String id);
}
