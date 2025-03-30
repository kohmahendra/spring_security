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
public class PaymentPK implements java.io.Serializable {
    private static final long serialVersionUID = -5921427254412401441L;
    @Column(name = "customer_number", nullable = false)
    private Integer customerNumber;

    @Column(name = "check_number", nullable = false, length = 50)
    private String checkNumber;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        final PaymentPK entity = (PaymentPK) o;
        return Objects.equals(this.checkNumber, entity.checkNumber) &&
                Objects.equals(this.customerNumber, entity.customerNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkNumber, customerNumber);
    }

}