package com.example.guestservice.dto;

import com.example.guestservice.model.National;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record GuestRequest(

        Integer id,

        @NotBlank(message = "Guest fullName is required")
        String fullName,

        @NotBlank(message = "Guest Email is required")
        @Email
        String email,

        @NotBlank(message = "Guest mobile num is required")
        String phone,

        National national


) {
}
