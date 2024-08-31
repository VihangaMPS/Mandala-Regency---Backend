package com.example.guestservice.dto;

import com.example.guestservice.model.National;

public record GuestResponse(
        Integer id,

        String fullName,

        String email,

        String phone,

        National national
) {
}
