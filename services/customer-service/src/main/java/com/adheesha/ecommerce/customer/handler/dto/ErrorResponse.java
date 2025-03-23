package com.adheesha.ecommerce.customer.handler.dto;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
