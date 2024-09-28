package com.fiap.healthmeduser.controller;

import com.fiap.healthmeduser.dto.DoctorDTO;
import com.fiap.healthmeduser.dto.PatientDTO;
import com.fiap.healthmeduser.model.Doctor;
import com.fiap.healthmeduser.model.Patient;
import com.fiap.healthmeduser.service.DoctorService;
import com.fiap.healthmeduser.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @PostMapping("/doctor/register")
    public ResponseEntity<Doctor> registerDoctor(@RequestBody DoctorDTO doctorDTO) {
        return ResponseEntity.ok(doctorService.registerDoctor(doctorDTO));
    }

    @PostMapping("/doctor/login")
    public ResponseEntity<Doctor> authenticateDoctor(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(doctorService.authenticateDoctor(email, password));
    }

    @PostMapping("/patient/register")
    public ResponseEntity<Patient> registerPatient(@RequestBody PatientDTO patientDTO) {
        return ResponseEntity.ok(patientService.registerPatient(patientDTO));
    }

    @PostMapping("/patient/login")
    public ResponseEntity<Patient> authenticatePatient(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(patientService.authenticatePatient(email, password));
    }
}
