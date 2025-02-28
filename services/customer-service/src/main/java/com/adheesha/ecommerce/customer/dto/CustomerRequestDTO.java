package com.adheesha.ecommerce.customer.dto;

import com.adheesha.ecommerce.customer.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequestDTO(
        @NotNull(message = "firstName is required")
        String firstName,

        @NotNull(message = "lastName is required")
        String lastName,

        @NotNull(message = "email is required")
        @Email(message = "email is invalid")
        String email,

        Address address
) {
}
