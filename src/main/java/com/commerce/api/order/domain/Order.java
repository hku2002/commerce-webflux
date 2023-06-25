package com.commerce.api.order.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@DynamicUpdate
@Table(name = "ORDERS")
@NoArgsConstructor(access = PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", insertable = false, updatable = false)
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "order", cascade = PERSIST)
    private List<OrderItem> orderItems = new ArrayList<>();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "total_price", nullable = false)
    private int totalPrice;

    @Builder
    public Order(Long id, Member member, List<OrderItem> orderItems, String name, int totalPrice) {
        this.id = id;
        this.orderItems = orderItems;
        this.name = name;
        this.totalPrice = totalPrice;
    }
}
