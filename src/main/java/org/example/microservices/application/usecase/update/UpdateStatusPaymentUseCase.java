package org.example.microservices.application.usecase.update;

import org.example.microservices.application.dto.command.SetOrderStatus;
import org.example.microservices.application.dto.result.ResultQuantityToRestock;

public interface UpdateStatusPaymentUseCase {
    ResultQuantityToRestock update(SetOrderStatus command);
}
