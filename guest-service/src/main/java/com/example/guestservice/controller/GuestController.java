package com.example.guestservice.controller;

import com.example.guestservice.dto.GuestRequest;
import com.example.guestservice.dto.GuestResponse;
import com.example.guestservice.model.Guest;
import com.example.guestservice.repo.GuestRepository;
import com.example.guestservice.service.GuestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/guest")
@RequiredArgsConstructor
@Slf4j
public class GuestController {

    private final GuestRepository guestRepository;
    private final GuestService guestService;

    @PostMapping("/test")
    public Guest save(@RequestBody Guest guest) {
        log.info("Guest saved: {}", guest);
        return guestRepository.save(guest);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GuestResponse> findAllGuests() {
        return guestService.findAll();
    }

    @GetMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public GuestResponse findGuestById(@PathVariable("customerId") int customerId) {
        return guestService.findById(customerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GuestResponse createGuest(@RequestBody @Valid GuestRequest guestRequest) {
        return guestService.save(guestRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGuestById(@PathVariable("customerId") int customerId) {
        guestService.delete(customerId);
    }

}
