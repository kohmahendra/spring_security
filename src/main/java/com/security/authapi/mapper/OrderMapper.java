package com.security.authapi.mapper;

import com.security.authapi.dtos.OrderDTO;
import com.security.authapi.entities.Customer;
import com.security.authapi.entities.Order;
import jakarta.transaction.Transactional;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Transactional
    OrderDTO mapOrderEntityToOrderDTO(Order entity);

    @Transactional
    List<OrderDTO> mapOrderEntitiesToOrderDTOs(List<Order> entities);

    @Transactional
    default Page<OrderDTO> getOrders(final Page<Order> source) {
        final List<OrderDTO> dtos = mapOrderEntitiesToOrderDTOs(source.getContent());
        final Pageable pageable = source.getPageable();
        return new PageImpl<>(dtos, pageable, source.getTotalElements());
    }

    @AfterMapping
    default void setOrderInfo(final Order order, @MappingTarget final OrderDTO orderDTO) {
        final Customer customer = order.getCustomer();
        if (customer != null &&
                customer.getSalesRepEmployeeNumber() != null &&
                customer.getSalesRepEmployeeNumber().getReportsTo() != null)
            orderDTO.getCustomer().getSalesRepEmployeeNumber().setReportsToEmployeeNumber(customer.getSalesRepEmployeeNumber().getReportsTo().getId());

        orderDTO.setStatusDescription(order.getStatus().getDescription());

    }
}
