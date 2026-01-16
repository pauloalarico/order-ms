package org.example.microservices.entitie;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.microservices.dto.request.RequestOrderDTO;
import org.example.microservices.enums.StatusOrder;

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
    @Column(name = "cd_idnt_product")
    private UUID productId;
    @Column(name = "nr_qty_product")
    private Integer quantity;
    @Column(name = "vl_total_value")
    private Double totalValue;
    @Column(name = "st_order")
    @Enumerated(EnumType.STRING)
    private StatusOrder statusOrder;

    public Order(RequestOrderDTO dto) {
        this.productId = dto.productId();
        this.quantity = dto.quantity();
        this.totalValue = null;
        this.statusOrder = StatusOrder.CREATED;
    }

    public void calculateTotalValue(BigDecimal price, Integer quantity) {
        this.totalValue = price.doubleValue() * quantity;
    }
}
