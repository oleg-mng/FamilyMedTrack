package com.olegmng.api;


import com.olegmng.entity.Doctor;
import com.olegmng.entity.Patient;
import com.olegmng.service.DoctorService;
import com.olegmng.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/doctor")
@Tag(name = "Doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    @Operation(summary = "Get all patients", description = "Getting all available patients in the system")
    public List<Doctor> getAllDoctors() {

        return doctorService.getAllDoctors();
    }
}