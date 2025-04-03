package com.security.authapi.services;

import com.security.authapi.entities.Order;
import com.security.authapi.model.OrderSearchParams;
import com.security.authapi.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order getOrder(final Integer orderNumber) {
        return orderRepository.findById(orderNumber).orElse(null);
    }

    @Transactional
    public Page<Order> getOrders(final OrderSearchParams orderSearchParams, final Pageable pageable) {
        return orderRepository.getOrders(orderSearchParams, pageable);
    }

}
