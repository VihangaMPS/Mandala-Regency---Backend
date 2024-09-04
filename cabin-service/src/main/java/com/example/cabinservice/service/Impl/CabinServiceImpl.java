package com.example.cabinservice.service.Impl;

import com.example.cabinservice.dto.CabinMapper;
import com.example.cabinservice.dto.CabinRequest;
import com.example.cabinservice.dto.CabinResponse;
import com.example.cabinservice.exception.CabinNotFoundException;
import com.example.cabinservice.model.Cabin;
import com.example.cabinservice.repository.CabinRepository;
import com.example.cabinservice.service.CabinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CabinServiceImpl implements CabinService {

    private final CabinRepository cabinRepository;
    private final CabinMapper cabinMapper;

    @Override
    public List<CabinResponse> getAllCabins() {
        return cabinRepository.findAll().stream().map(cabinMapper::toCabinResponse).toList();
    }

    @Override
    public CabinResponse getCabinById(Integer cabinId) {
        return cabinRepository.findById(cabinId).map(cabinMapper::toCabinResponse)
                .orElseThrow(() -> new CabinNotFoundException("Cabin not found " + cabinId));
    }

    @Override
    public Integer saveCabin(CabinRequest cabinRequest) {

        Cabin cabin = cabinMapper.toCabin(cabinRequest);
        log.info("Saving cabin {}", cabin);

        return cabinRepository.save(cabin).getId();
    }
}
