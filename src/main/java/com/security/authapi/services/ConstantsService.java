package com.security.authapi.services;

import com.security.authapi.constants.APP_CONSTANTS;
import com.security.authapi.constants.OrderStatus;
import com.security.authapi.constants.SimpleStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConstantsService {
    public Map<String, List<SimpleStatus>> getOrderConstants() {
        final Map<String, List<SimpleStatus>> constants = new HashMap<>();
        final List<SimpleStatus> orderStatus = new ArrayList<>();
        for (final OrderStatus status : OrderStatus.values()) {
            orderStatus.add(SimpleStatus.builder().id(status.name()).description(status.getDescription()).build());
        }
        constants.put(APP_CONSTANTS.ORDER_STATUSES, orderStatus);
        return constants;

    }
}
