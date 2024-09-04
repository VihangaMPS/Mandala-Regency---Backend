package com.example.cabinservice.controller;

import com.example.cabinservice.dto.CabinRequest;
import com.example.cabinservice.dto.CabinResponse;
import com.example.cabinservice.service.CabinService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/cabin")
@RequiredArgsConstructor
@Slf4j
public class CabinController {

    private final CabinService cabinService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CabinResponse> getAllCabins() {
        return cabinService.getAllCabins();
    }

    @GetMapping("/{cabinId}")
    @ResponseStatus(HttpStatus.OK)
    public CabinResponse getCabinById(@PathVariable Integer cabinId) {
        return cabinService.getCabinById(cabinId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer createCabin(@RequestBody @Valid CabinRequest cabinRequest) throws IOException {
        return cabinService.saveCabin(cabinRequest);
    }
}
