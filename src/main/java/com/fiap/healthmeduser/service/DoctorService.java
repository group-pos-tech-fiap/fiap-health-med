package com.fiap.healthmeduser.service;

import com.fiap.healthmeduser.dto.DoctorDTO;
import com.fiap.healthmeduser.exception.UserAlreadyExistsException;
import com.fiap.healthmeduser.model.Doctor;
import com.fiap.healthmeduser.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Doctor registerDoctor(DoctorDTO doctorDTO) {
        if (doctorRepository.findByEmail(doctorDTO.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Doctor already exists");
        }

        Doctor doctor = new Doctor();
        doctor.setName(doctorDTO.getName());
        doctor.setCpf(doctorDTO.getCpf());
        doctor.setCrm(doctorDTO.getCrm());
        doctor.setEmail(doctorDTO.getEmail());
        doctor.setPassword(passwordEncoder.encode(doctorDTO.getPassword()));

        return doctorRepository.save(doctor);
    }

    public Doctor authenticateDoctor(String email, String password) {
        Doctor doctor = doctorRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        if (!passwordEncoder.matches(password, doctor.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return doctor;
    }
}
