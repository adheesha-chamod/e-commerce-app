package com.adheesha.ecommerce.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Validated
public class Address {

    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
}
