package com.security.authapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_number", nullable = false)
    private Integer id;

    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    @Column(name = "required_date", nullable = false)
    private LocalDate requiredDate;

    @Column(name = "shipped_Date")
    private LocalDate shippedDate;

    @Column(name = "status", nullable = false, length = 15)
    private String status;

    @Lob
    @Column(name = "comments")
    private String comments;

    @Column(name = "customer_number", nullable = false)
    private Integer customerNumber;

}