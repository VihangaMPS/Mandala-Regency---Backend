package com.example.cabinservice.dto;

import java.math.BigDecimal;

public record CabinResponse (
        Integer id,
        String cabinName,
        BigDecimal cabinPrice,
        int guestCount,

        Integer categoryId,
        String categoryName,
        String categoryDescription
){
}
