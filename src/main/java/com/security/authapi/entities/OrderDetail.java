package com.security.authapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "order_details")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailPK id;

    @Column(name = "quantity_ordered", nullable = false)
    private Integer quantityOrdered;

    @Column(name = "price_each", nullable = false, precision = 10, scale = 2)
    private BigDecimal priceEach;

    @Column(name = "order_line_number", nullable = false)
    private Short orderLineNumber;

}