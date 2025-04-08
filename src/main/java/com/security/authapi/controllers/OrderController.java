package com.security.authapi.controllers;

import com.security.authapi.dtos.OrderDTO;
import com.security.authapi.entities.Order;
import com.security.authapi.model.OrderSearchParams;
import com.security.authapi.services.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/order")
@RestController
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/{orderNumber}")
    public Order getOrder(@PathVariable final Integer orderNumber) {
        return orderService.getOrder(orderNumber);
    }

    @GetMapping()
    public Page<OrderDTO> getOrders(@Valid final OrderSearchParams searchParams, @PageableDefault(size = 20) final Pageable pageable) {
        return orderService.getOrders(searchParams, pageable);
    }

}
