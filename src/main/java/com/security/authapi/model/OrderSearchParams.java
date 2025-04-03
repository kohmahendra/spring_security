package com.security.authapi.model;

//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderSearchParams {

    //@NotNull
    //@NotEmpty
    private String orderNumber;
    private String customerNumber;

}
