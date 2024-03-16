package com.olegmng.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "calendar")
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "patient_id")
    private Long patient_id;

    @Column(name = "doctor_id")
    private Long doctor_id;

    public Calendar() {
    }

    public Calendar(LocalDate date, Long patient_id, Long doctor_id) {
        this.date = date;
        this.patient_id = patient_id;
        this.doctor_id = doctor_id;
    }
}
