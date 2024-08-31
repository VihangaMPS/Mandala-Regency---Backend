package com.example.guestservice.service;


import com.example.guestservice.dto.GuestRequest;
import com.example.guestservice.dto.GuestResponse;

import java.util.List;

public interface GuestService {

    List<GuestResponse> findAll();

    GuestResponse findById(int id);

    GuestResponse save(GuestRequest guestRequest);

    void delete(int id);

}
