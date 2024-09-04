package com.example.cabinservice.dto;

import com.example.cabinservice.model.Cabin;
import com.example.cabinservice.model.Category;
import org.springframework.stereotype.Service;

@Service
public class CabinMapper {

    public Cabin toCabin(CabinRequest cabinRequest) {
        return Cabin.builder()
                .id(cabinRequest.getId())
                .name(cabinRequest.getName())
                .price(cabinRequest.getPrice())
                .guestcount(cabinRequest.getGuestCount())
                .category(
                        Category.builder()
                                .id(cabinRequest.getId())
                                .build()
                )
                .build();
    }

    public CabinResponse toCabinResponse(Cabin cabin) {

        return new CabinResponse(
                cabin.getId(),
                cabin.getName(),
                cabin.getPrice(),
                cabin.getGuestcount(),
                cabin.getCategory().getName(),
                cabin.getCategory().getDescription()
        );
    }
}
