package org.example.microservices.http;

import org.example.microservices.application.dto.request.RealizePaymentDto;
import org.example.microservices.application.dto.response.ListReponsePaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("payment-microsservice")
public interface PaymentClient {
    @RequestMapping(method = RequestMethod.POST, value = "/payments")
    ListReponsePaymentDto realizePayment(@RequestBody RealizePaymentDto dto);

}
