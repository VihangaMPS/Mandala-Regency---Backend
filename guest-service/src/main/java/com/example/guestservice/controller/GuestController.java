package com.example.guestservice.controller;

import com.example.guestservice.model.Guest;
import com.example.guestservice.repo.GuestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/guest")
@RequiredArgsConstructor
@Slf4j
public class GuestController {

    private final GuestRepository guestRepository;

    @PostMapping
    public Guest save(@RequestBody Guest guest) {
        log.info("Guest saved: {}", guest);
        return guestRepository.save(guest);
    }

}
