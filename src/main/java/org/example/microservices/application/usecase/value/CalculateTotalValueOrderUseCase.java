package org.example.microservices.application.usecase.value;

import org.example.microservices.application.dto.command.CalculateOrderTotalValue;
import org.example.microservices.application.dto.result.ResultCalculatedOrderTotalValue;

public interface CalculateTotalValueOrderUseCase {
    ResultCalculatedOrderTotalValue execute(CalculateOrderTotalValue command);
}
