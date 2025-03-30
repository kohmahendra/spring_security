package com.security.authapi.controllers;

import com.security.authapi.entities.Order;
import com.security.authapi.services.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/orders")
@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{orderNumber}")
    public Order getOrder(@PathVariable final Integer orderNumber) {
        return orderService.getOrder(orderNumber);
    }

    @GetMapping()
    public Page<Order> getOrders(final Pageable pageable) {
        return orderService.getOrders(pageable);
    }

}
