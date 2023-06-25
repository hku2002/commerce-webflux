package com.commerce.api.order.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "ORDER_ITEM")
@NoArgsConstructor(access = PROTECTED)
public class OrderItem {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id", updatable = false)
    private Order order;

    @Column(name = "item_id", nullable = false)
    private Long itemId;

    @Column(name = "supply_price", nullable = false)
    private int supplyPrice;

    @Column(name = "user_purchase_quantity", nullable = false)
    private int userPurchaseQuantity;

    @Column(name = "item_used_quantity", nullable = false)
    private int itemUsedQuantity;

    @Column(name = "activated", nullable = false)
    private boolean activated;

    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Builder
    public OrderItem(Long id, Order order, Long itemId, int supplyPrice, int userPurchaseQuantity, int itemUsedQuantity) {
        this.id = id;
        this.order = order;
        this.itemId = itemId;
        this.supplyPrice = supplyPrice;
        this.userPurchaseQuantity = userPurchaseQuantity;
        this.itemUsedQuantity = itemUsedQuantity;
        this.activated = true;
        this.createdAt = LocalDateTime.now();
    }
}
