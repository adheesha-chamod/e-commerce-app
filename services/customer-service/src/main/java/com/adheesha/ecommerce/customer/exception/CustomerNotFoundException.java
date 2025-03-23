package com.adheesha.ecommerce.customer.exception;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String customerId) {
        super(String.format("Customer with id '%s' not found", customerId));
    }
}
