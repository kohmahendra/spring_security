package com.security.authapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Size(max = 15)
    @Column(name = "product_code", nullable = false, length = 15)
    private String productCode;

    @Size(max = 70)
    @NotNull
    @Column(name = "product_name", nullable = false, length = 70)
    private String productName;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_line", nullable = false)
    private ProductLine productLine;

    @Size(max = 10)
    @NotNull
    @Column(name = "product_scale", nullable = false, length = 10)
    private String productScale;

    @Size(max = 50)
    @NotNull
    @Column(name = "product_vendor", nullable = false, length = 50)
    private String productVendor;

    @NotNull
    @Lob
    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @NotNull
    @Column(name = "quantity_in_stock", nullable = false)
    private Short quantityInStock;

    @NotNull
    @Column(name = "buy_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal buyPrice;

    @NotNull
    @Column(name = "MSRP", nullable = false, precision = 10, scale = 2)
    private BigDecimal msrp;

}