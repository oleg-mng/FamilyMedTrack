package com.olegmng.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctor_id;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "direction")
    private String direction;

    @Column(name = "experience")
    private Long experience;

    @Column(name = "clinic")
    private String clinic;

    public Doctor() {
    }

    public Doctor(String lastName, String direction, Long experience, String clinic) {
        this.lastName = lastName;
        this.direction = direction;
        this.experience = experience;
        this.clinic = clinic;
    }
}