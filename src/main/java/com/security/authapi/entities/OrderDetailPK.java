package com.security.authapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@Embeddable
public class OrderDetailPK implements java.io.Serializable {
    private static final long serialVersionUID = -172610043574238861L;
    @Column(name = "order_number", nullable = false)
    private Integer orderNumber;

    @Column(name = "product_code", nullable = false, length = 15)
    private String productCode;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        final OrderDetailPK entity = (OrderDetailPK) o;
        return Objects.equals(this.orderNumber, entity.orderNumber) &&
                Objects.equals(this.productCode, entity.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, productCode);
    }

}