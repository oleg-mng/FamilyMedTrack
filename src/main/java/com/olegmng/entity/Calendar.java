package com.olegmng.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.print.Doc;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "calendar")
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "doctor")
    private String doctor;

    @Column(name = "patient")
    private String patient;
}
