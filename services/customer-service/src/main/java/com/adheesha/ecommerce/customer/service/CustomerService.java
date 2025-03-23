package com.adheesha.ecommerce.customer.service;

import com.adheesha.ecommerce.customer.dto.CustomerRequestDTO;
import com.adheesha.ecommerce.customer.dto.CustomerResponseDTO;
import com.adheesha.ecommerce.customer.entity.Customer;
import com.adheesha.ecommerce.customer.exception.CustomerNotFoundException;
import com.adheesha.ecommerce.customer.mapper.CustomerMapper;
import com.adheesha.ecommerce.customer.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    public String createCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer savedCustomer = customerRepository.save(customerMapper.toCustomer(customerRequestDTO));
        return savedCustomer.getId();
    }

    public CustomerResponseDTO findCustomerById(String customerId) {
        return customerRepository.findById(customerId)
                .map(customerMapper::toCustomerResponseDTO)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
    }

    public List<CustomerResponseDTO> findAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toCustomerResponseDTO)
                .toList();
    }

    public void updateCustomer(String customerId, @Valid CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new CustomerNotFoundException(customerId)
        );

        mergeCustomer(customer, customerRequestDTO);
        customerRepository.save(customer);
    }

    public void deleteCustomerById(String customerId) {
        customerRepository.deleteById(customerId);
    }

    private void mergeCustomer(Customer customer, CustomerRequestDTO customerRequestDTO) {
        if (!customerRequestDTO.firstName().isBlank()) {
            customer.setFirstName(customerRequestDTO.firstName());
        }
        if (!customerRequestDTO.lastName().isBlank()) {
            customer.setLastName(customerRequestDTO.lastName());
        }
        if (!customerRequestDTO.email().isBlank()) {
            customer.setEmail(customerRequestDTO.email());
        }
        if (customerRequestDTO.address() != null) {
            customer.setAddress(customerRequestDTO.address());
        }
    }
}
