package com.security.authapi.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {
    SHIPPED("Shipped"),
    RESOLVED("Resolved"),
    CANCELLED("Cancelled"),
    ON_HOLD("On Hold"),
    DISPUTED("Disputed"),
    IN_PROCESS("In Process");

    private final String description;

}
