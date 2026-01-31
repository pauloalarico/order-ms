package org.example.microservices.model.entitie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.microservices.application.dto.command.RequestOrderDTO;
import org.example.microservices.model.enums.StatusOrder;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "ms_orders")
@RequiredArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "cd_idnt_order", unique = true)
    private UUID orderId;
    @Column(name = "cd_correlation_id", unique = true)
    private UUID correlationId;
    @Column(name = "cd_idnt_product")
    private UUID productId;
    @Column(name = "nr_qty_product")
    private Integer quantity;
    @Column(name = "vl_total_value")
    private BigDecimal totalValue;
    @Column(name = "st_order")
    @Enumerated(EnumType.STRING)
    private StatusOrder statusOrder;

    public Order(RequestOrderDTO dto) {
        this.productId = dto.productId();
        this.correlationId = generateUid();
        this.quantity = dto.quantity();
        this.totalValue = null;
        this.statusOrder = StatusOrder.CREATED;
    }

    public void calculateTotalValue(BigDecimal price) {
        this.totalValue = price.multiply(BigDecimal.valueOf(this.quantity));
    }

    public void cancelStatusOrder() {
        this.statusOrder = StatusOrder.CANCELLED;
    }

    public void paymentApproved() {
        this.statusOrder = StatusOrder.PAID;
    }

    private UUID generateUid() {
        return UUID.randomUUID();
    }
}
