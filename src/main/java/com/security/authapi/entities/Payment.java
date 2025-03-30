package com.security.authapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment {
    @EmbeddedId
    private PaymentPK id;

    
    @Column(name = "payment_date", nullable = false)
    private LocalDate paymentDate;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

}