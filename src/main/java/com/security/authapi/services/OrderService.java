package com.security.authapi.services;

import com.security.authapi.dtos.OrderDTO;
import com.security.authapi.entities.Order;
import com.security.authapi.mapper.OrderMapper;
import com.security.authapi.model.OrderSearchParams;
import com.security.authapi.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;


    @Transactional
    public Order getOrder(final Integer orderNumber) {
        return orderRepository.findById(orderNumber).orElse(null);
    }

    @Transactional
    public Page<OrderDTO> getOrders(final OrderSearchParams orderSearchParams, final Pageable pageable) {
        final Page<Order> pagedOrders = orderRepository.getOrders(orderSearchParams, pageable);

        return orderMapper.getOrders(pagedOrders);
    }

}
