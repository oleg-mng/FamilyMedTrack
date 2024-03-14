package com.olegmng.service;

import com.olegmng.entity.Doctor;
import com.olegmng.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        doctorRepository.save(new Doctor("Usikov", "surgery", 11L, "MedCity"));
        doctorRepository.save(new Doctor("Kirpichnikova", "therapist", 15L, "Family"));
        doctorRepository.save(new Doctor("Salimov", "ent", 7L, "Medsi"));
        doctorRepository.save(new Doctor("Polevoi", "dentist", 21L, "MedSwiss"));

        return doctorRepository.findAll();
    }
}
