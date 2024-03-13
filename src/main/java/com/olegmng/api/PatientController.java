package com.olegmng.api;

import com.olegmng.entity.Patient;
import com.olegmng.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/patient")
@Tag(name = "Book")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    @Operation(summary = "Get all books", description = "Getting all available books in the system")
    public List<Patient> getAllBooks() {

        return patientService.getAllBooks();
    }
}
