package com.security.authapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @Column(name = "customer_number", nullable = false)
    private Integer id;

    @Column(name = "customer_name", nullable = false, length = 50)
    private String customerName;

    @Column(name = "contact_last_name", nullable = false, length = 50)
    private String contactLastName;

    @Column(name = "contact_first_name", nullable = false, length = 50)
    private String contactFirstName;

    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

    @Column(name = "address_line1", nullable = false, length = 50)
    private String addressLine1;

    @Column(name = "address_line2", length = 50)
    private String addressLine2;

    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "postal_Code", length = 15)
    private String postalCode;

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @Column(name = "sales_rep_employee_number")
    private Integer salesRepEmployeeNumber;

    @Column(name = "credit_limit", precision = 10, scale = 2)
    private BigDecimal creditLimit;

}