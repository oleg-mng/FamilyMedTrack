package com.olegmng.api;

import com.olegmng.dto.ReportDTO;
import com.olegmng.entity.Report;
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
@RequestMapping("/report")
@Tag(name = "Report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    @Operation(summary = "Get all reports", description = "Getting all available reports in the system")
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @PostMapping
    @Operation(summary = "Add new report", description = "Adding new report in system")
    public List<Report> addReport(@RequestBody Report report) {
        return reportService.saveReport(report);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get report by id", description = "Getting available report by id in the system")
    public Optional<Report> getAllDoctors(@PathVariable Long id) {
        return reportService.getReportById(id);
    }

    @DeleteMapping ("/delete/{id}")
    @Operation(summary = "Delete report by id", description = "Getting available report by id in the system")
    public List<Report> deleteReportById(@PathVariable Long id) {
        return reportService.deleteReportById(id);
    }

    @GetMapping("/patient/{id}")
    @Operation(summary = "Get reports by patient_id", description = "Getting available reports by patient_id in the system")
    public List<Report> getReportByPatientId(@PathVariable Long id) {
        return reportService.getReportByPatientId(id);
    }
}