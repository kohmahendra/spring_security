package com.security.authapi.services;

import com.security.authapi.dtos.CustomerDTO;
import com.security.authapi.entities.Customer;
import com.security.authapi.mapper.CustomerMapper;
import com.security.authapi.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    final CustomerRepository customerRepository;
    final CustomerMapper customerMapper;

    public Page<CustomerDTO> getCustomers(final Pageable pageable) {
        final Page<Customer> pagedCustomers = customerRepository.findAll(pageable);
        return customerMapper.getCustomerDtos(pagedCustomers);
    }

    @Transactional
    public CustomerDTO getCustomer(final Integer customerNumber) {
        return customerRepository.findById(customerNumber)
                .map(customerMapper::mapCustomerEntityToCustomerDTO)
                .orElse(null);
    }
}
