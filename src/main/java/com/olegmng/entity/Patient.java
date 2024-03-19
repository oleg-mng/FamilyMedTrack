package com.olegmng.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patient_id;

    //реализация связи один ко многим для работе с h2db
//    @OneToMany(targetEntity = Report.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
//    private List<Report> reportList = new ArrayList<>();

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    public Patient() {
    }

    public Patient(String login, String password) {
        this.login = login;
        this.password = password;
    }
}