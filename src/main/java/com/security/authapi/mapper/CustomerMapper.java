package com.security.authapi.mapper;

import com.security.authapi.dtos.CustomerDTO;
import com.security.authapi.entities.Customer;
import jakarta.transaction.Transactional;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Transactional
    CustomerDTO mapCustomerEntityToCustomerDTO(Customer entity);

    @Transactional
    List<CustomerDTO> mapCustomerEntitiesToCustomerDTOList(List<Customer> entities);

    @Transactional
    default Page<CustomerDTO> getCustomerDtos(final Page<Customer> source) {
        final List<CustomerDTO> dtos = mapCustomerEntitiesToCustomerDTOList(source.getContent());
        final Pageable pageable = source.getPageable();
        return new PageImpl<>(dtos, pageable, source.getTotalElements());
    }

    @AfterMapping
    default void updateReportsTo(final Customer customer, @MappingTarget final CustomerDTO customerDTO) {

        if (customer != null &&
                customer.getSalesRepEmployeeNumber() != null &&
                customer.getSalesRepEmployeeNumber().getReportsTo() != null)
            customerDTO.getSalesRepEmployeeNumber().setReportsToEmployeeNumber(customer.getSalesRepEmployeeNumber().getReportsTo().getId());

    }
}
