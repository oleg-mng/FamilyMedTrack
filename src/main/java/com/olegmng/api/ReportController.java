package com.olegmng.api;

import com.olegmng.entity.Report;
import com.olegmng.service.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/report")
@Tag(name = "Report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    @Operation(summary = "Get all reports", description = "Getting all available reports in the system")
    public List<Report> getAllDoctors() {

        return reportService.getAllReports();
    }

    @PostMapping
    @Operation(summary = "Add new report", description = "Adding new report in system")
    public List<Report> addReport(@RequestBody String type, LocalDate date, String scan, Long patient_id, Long doctor_id) {
        return reportService.saveReport(type, date, scan, patient_id, doctor_id);
    }
}