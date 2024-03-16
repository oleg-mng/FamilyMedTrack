package com.olegmng.api;

import com.olegmng.entity.Patient;
import com.olegmng.entity.Report;
import com.olegmng.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping("/patient")
@Tag(name = "Patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    @Operation(summary = "Get all patients", description = "Getting all available patients in the system")
    public List<Patient> getAllPatient() {

        return patientService.getAllPatients();
    }

    @PostMapping
    @Operation(summary = "Add new patient", description = "Adding new patient in system")
    public List<Patient> addPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get patient by id", description = "Getting available patient by id in the system")
    public Optional<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }
}
