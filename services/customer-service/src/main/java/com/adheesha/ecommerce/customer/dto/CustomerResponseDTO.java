package com.adheesha.ecommerce.customer.dto;

import com.adheesha.ecommerce.customer.entity.Address;

public record CustomerResponseDTO(
        String id,
        String firstName,
        String lastName,
        String email,
        Address address
) {
}
