package com.adheesha.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerRequest(
        String id,

        @NotBlank(message = "Customer first name cannot be blank")
        String firstName,

        @NotBlank(message = "Customer last name cannot be blank")
        String lastName,

        @NotBlank(message = "Customer email cannot be blank")
        @Email(message = "Customer email must be a valid email address")
        String email,

        Address address
) {
}
