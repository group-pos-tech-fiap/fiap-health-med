package com.fiap.healthmeduser.repository;

import com.fiap.healthmeduser.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
    Optional<Doctor> findByEmail(String email);
}

