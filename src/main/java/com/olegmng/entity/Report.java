package com.olegmng.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long report_id;

    @Column(name = "type")
    private String type;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "scan")
    private String scan;

    @Column(name = "patient_id")
    private Long patient_id;

    @Column(name = "doctor_id")
    private Long doctor_id;

    public Report() {
    }

    public Report(String type, LocalDate date, String scan, Long patient_id, Long doctor_id) {
        this.type = type;
        this.date = date;
        this.scan = scan;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
    }
}