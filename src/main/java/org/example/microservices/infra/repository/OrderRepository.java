package org.example.microservices.infra.repository;

import org.example.microservices.domain.entitie.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    @Query("SELECT o FROM Order o WHERE o.correlationId = :uuid")
    Optional<Order> getOrder(@Param("uuid") UUID uuid);

    @Query("SELECT o FROM Order o WHERE o.orderId = :orderId")
    Optional<Order> getOrderByOrderId(@Param("orderId") String orderId);
}
