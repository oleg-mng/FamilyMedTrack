package com.olegmng.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lastName")
    private String login;

    @Column(name = "direction")
    private String direction;

    @Column(name = "experience")
    private String experience;

    @Column(name = "clinic")
    private String clinic;
}