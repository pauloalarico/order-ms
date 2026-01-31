package org.example.microservices.application.usecase.create;

import lombok.RequiredArgsConstructor;
import org.example.microservices.application.dto.command.RequestOrderDTO;
import org.example.microservices.application.dto.shared.response.CompleteOrderDTO;
import org.example.microservices.application.usecase.OrderEventCreatedPublisher;
import org.example.microservices.model.entitie.Order;
import org.example.microservices.infra.repository.OrderRepository;
import org.example.microservices.utils.CommandMapper;
import org.example.microservices.utils.OrderMapperDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateNewOrderService implements CreateNewOrderUseCase {

    private final OrderRepository repository;
    private final OrderEventCreatedPublisher publisher;

    @Override
    public CompleteOrderDTO create(RequestOrderDTO command) {
        var order = new Order(command);
        repository.save(order);
        var result = CommandMapper.getProduct(order, command.productId());
        publisher.publish(result);
        return OrderMapperDTO.createCompleteDto(order);
    }
}
