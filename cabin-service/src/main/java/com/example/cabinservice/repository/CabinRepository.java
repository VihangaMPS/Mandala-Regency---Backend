package com.example.cabinservice.repository;

import com.example.cabinservice.model.Cabin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabinRepository extends JpaRepository<Cabin, Integer> {
}
