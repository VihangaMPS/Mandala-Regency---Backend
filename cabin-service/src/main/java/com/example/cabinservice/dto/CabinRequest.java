package com.example.cabinservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CabinRequest {
        Integer id;

        @NotBlank(message = "Cabin name is required")
        String name;

        @Positive(message = "Price should be positive")
        BigDecimal price;

        int guestCount;

        Integer categoryId;
}
