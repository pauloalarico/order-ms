package org.example.microservices.application.usecase;

import org.example.microservices.application.dto.result.ResultCalculatedOrderTotalValue;
import org.example.microservices.application.dto.result.ResultOrderCreated;
import org.example.microservices.application.dto.result.ResultQuantityToRestock;

public interface OrderEventCreatedPublisher {
    void publish (ResultCalculatedOrderTotalValue result);

    void publish (ResultQuantityToRestock result);

    void publish(ResultOrderCreated result);
}
