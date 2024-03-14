package com.olegmng.service;

import com.olegmng.entity.Report;
import com.olegmng.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

    @Service
    public class ReportService {

        @Autowired
        private ReportRepository reportRepository;

        public List<Report> getAllReports() {
            reportRepository.save(new Report("dentalImage", LocalDate.of(2022, 1, 5), "scan1.png", 1L, 4L));
            reportRepository.save(new Report("analysis", LocalDate.of(2023, 3, 27), "scan2.png", 2L, 3L));
            reportRepository.save(new Report("diagnosis", LocalDate.of(2024, 1, 17), "scan3.jpg", 3L, 1L));
            reportRepository.save(new Report("analysis", LocalDate.of(2022, 11, 11), "scan4.pdf", 1L, 2L));

            return reportRepository.findAll();
        }


        public List<Report> saveReport(String type, LocalDate date, String scan, Long patient_id, Long doctor_id){
            reportRepository.save(new Report(type, date, scan, patient_id, doctor_id));

            return reportRepository.findAll();
        }
    }
