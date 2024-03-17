package com.olegmng.api;

import com.olegmng.dto.PatientDTO;
import com.olegmng.entity.Patient;
import com.olegmng.entity.Report;
import com.olegmng.service.PatientService;
import com.olegmng.service.ReportService;
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

    @Autowired
    private ReportService reportService;

    @GetMapping
    @Operation(summary = "Get all patients", description = "Getting all available patients in the system")
    public List<Patient> getAllPatient() {

        return patientService.getAllPatients();
    }

    @PostMapping
    @Operation(summary = "Add new patient", description = "Adding new patient in system")
    public List<Patient> addPatient(@RequestBody PatientDTO patient) {
        return patientService.savePatient(patient);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get patient by id", description = "Getting available patient by id in the system")
    public Optional<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/report/{id}")
    @Operation(summary = "Get reports by patient_id", description = "Getting available reports by patient_id in the system")
    public Optional<Report> getReportByPatientId(@PathVariable Long id) {
        return reportService.getReportByPatientId(id);
    }
}
