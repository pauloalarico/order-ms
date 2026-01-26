package org.example.microservices.application.usecase.create;

import org.example.microservices.application.dto.command.RequestOrderDTO;
import org.example.microservices.application.dto.shared.response.CompleteOrderDTO;

public interface CreateNewOrderUseCase {
     CompleteOrderDTO create(RequestOrderDTO command);
}
