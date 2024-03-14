package com.olegmng.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "scan")
    private String scan;

    @Column(name = "patient_id")
    private Long patient_id;

    @Column(name = "doctor_id")
    private Long doctor_id;
}