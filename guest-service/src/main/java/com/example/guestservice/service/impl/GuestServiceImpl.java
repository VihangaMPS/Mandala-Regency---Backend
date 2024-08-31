package com.example.guestservice.service.impl;


import com.example.guestservice.dto.GuestMapper;
import com.example.guestservice.dto.GuestRequest;
import com.example.guestservice.dto.GuestResponse;
import com.example.guestservice.exception.GuestNotFoundException;
import com.example.guestservice.model.Guest;

import com.example.guestservice.repo.GuestRepository;
import com.example.guestservice.service.GuestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;
    private final GuestMapper mapper;

    @Override
    public List<GuestResponse> findAll() {
        return guestRepository.findAll().stream().map(mapper::fromGuest).collect(Collectors.toList());
    }

    @Override
    public GuestResponse findById(int id) {
        return guestRepository.findById(id).map(mapper::fromGuest)
                .orElseThrow(() -> new GuestNotFoundException("Student id not found - " + id));
    }

    @Override
    public GuestResponse save(GuestRequest guestRequest) {
        log.info("Saving guest {}", guestRequest);

        Guest guest = guestRepository.save(mapper.toGuest(guestRequest));
        log.info("Saved guest {}", guest);
        return new GuestResponse(
                guest.getId(),
                guest.getFullName(),
                guest.getEmail(),
                guest.getPhone(),
                guest.getNational()

        );
    }

    @Override
    public void delete(int id) {
        guestRepository.deleteById(id);
    }
}
