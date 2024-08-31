package com.example.guestservice.dto;

import com.example.guestservice.model.Guest;
import org.springframework.stereotype.Component;

@Component
public class GuestMapper {

    public Guest toGuest(GuestRequest guestRequest) {
        if (guestRequest == null) return null;

        return Guest.builder()
                .id(guestRequest.id())
                .fullName(guestRequest.fullName())
                .email(guestRequest.email())
                .phone(guestRequest.phone())
                .national(guestRequest.national())
                .build();
    }

    public GuestResponse fromGuest(Guest guest) {
        if (guest == null) return null;

        return new GuestResponse(
                guest.getId(),
                guest.getFullName(),
                guest.getEmail(),
                guest.getPhone(),
                guest.getNational()
        );
    }
}
