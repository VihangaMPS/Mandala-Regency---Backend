package com.example.guestservice.repo;

import com.example.guestservice.model.Guest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuestRepository extends MongoRepository<Guest, Integer> {

}
