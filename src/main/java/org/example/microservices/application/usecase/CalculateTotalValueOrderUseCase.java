package org.example.microservices.application.usecase;

import org.example.microservices.application.dto.command.CalculateOrderTotalValue;
import org.example.microservices.application.dto.result.ResultCalculatedOrderTotalValue;

public interface CalculateTotalValueOrderUseCase {
    ResultCalculatedOrderTotalValue execute(CalculateOrderTotalValue command);
}
