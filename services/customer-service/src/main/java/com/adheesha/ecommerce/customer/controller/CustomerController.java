package com.adheesha.ecommerce.customer.controller;

import com.adheesha.ecommerce.customer.dto.CustomerRequestDTO;
import com.adheesha.ecommerce.customer.dto.CustomerResponseDTO;
import com.adheesha.ecommerce.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @PostMapping
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequestDTO customerRequestDTO
    ) {
        return ResponseEntity.ok(customerService.createCustomer(customerRequestDTO));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDTO> findCustomerById(
            @PathVariable String customerId
    ) {
        return ResponseEntity.ok(customerService.findCustomerById(customerId));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> findAllCustomers() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Void> updateCustomer(
            @RequestBody @Valid CustomerRequestDTO customerRequestDTO,
            @PathVariable String customerId
    ) {
        customerService.updateCustomer(customerId, customerRequestDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomerById(
            @PathVariable String customerId
    ) {
        customerService.deleteCustomerById(customerId);
        return ResponseEntity.noContent().build();
    }
}
