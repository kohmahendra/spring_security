package com.security.authapi.controllers;

import com.security.authapi.dtos.CustomerDTO;
import com.security.authapi.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/customer")
@RestController
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{customerNumber}")
    public CustomerDTO getCustomer(@PathVariable final Integer customerNumber) {
        return customerService.getCustomer(customerNumber);
    }
}
