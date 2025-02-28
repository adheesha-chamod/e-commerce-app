package com.adheesha.ecommerce.customer.mapper;

import com.adheesha.ecommerce.customer.dto.CustomerRequestDTO;
import com.adheesha.ecommerce.customer.dto.CustomerResponseDTO;
import com.adheesha.ecommerce.customer.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public Customer toCustomer(CustomerRequestDTO customerRequestDTO) {
        return Customer.builder()
                .firstName(customerRequestDTO.firstName())
                .lastName(customerRequestDTO.lastName())
                .email(customerRequestDTO.email())
                .address(customerRequestDTO.address())
                .build();
    }

    public CustomerResponseDTO toCustomerResponseDTO(Customer customer) {
        return new CustomerResponseDTO(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
