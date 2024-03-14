package com.olegmng.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patient_id;

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