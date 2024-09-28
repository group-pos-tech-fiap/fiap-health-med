package com.fiap.healthmeduser.service;

import com.fiap.healthmeduser.dto.PatientDTO;
import com.fiap.healthmeduser.exception.UserAlreadyExistsException;
import com.fiap.healthmeduser.model.Patient;
import com.fiap.healthmeduser.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Patient registerPatient(PatientDTO patientDTO) {
        if (patientRepository.findByEmail(patientDTO.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Patient already exists");
        }

        Patient patient = new Patient();
        patient.setName(patientDTO.getName());
        patient.setCpf(patientDTO.getCpf());
        patient.setEmail(patientDTO.getEmail());
        patient.setPassword(passwordEncoder.encode(patientDTO.getPassword()));

        return patientRepository.save(patient);
    }

    public Patient authenticatePatient(String email, String password) {
        Patient patient = patientRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        if (!passwordEncoder.matches(password, patient.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return patient;
    }
}
