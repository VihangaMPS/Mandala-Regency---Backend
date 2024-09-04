package com.example.cabinservice.service;

import com.example.cabinservice.dto.CabinRequest;
import com.example.cabinservice.dto.CabinResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CabinService {

    List<CabinResponse> getAllCabins();

    CabinResponse getCabinById(Integer cabinId);

    Integer saveCabin(CabinRequest cabinRequest);
}
