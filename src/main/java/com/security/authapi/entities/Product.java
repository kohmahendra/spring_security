package com.security.authapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "product_code", nullable = false, length = 15)
    private String productCode;

    @Column(name = "product_name", nullable = false, length = 70)
    private String productName;

    @Column(name = "product_line", nullable = false)
    private String productLine;

    @Column(name = "product_scale", nullable = false, length = 10)
    private String productScale;

    @Column(name = "product_vendor", nullable = false, length = 50)
    private String productVendor;

    @Lob
    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "quantity_in_stock", nullable = false)
    private Short quantityInStock;

    @Column(name = "buy_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal buyPrice;

    @Column(name = "MSRP", nullable = false, precision = 10, scale = 2)
    private BigDecimal msrp;

}