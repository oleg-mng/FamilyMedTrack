package com.olegmng.service;

import com.olegmng.dto.DoctorDTO;
import com.olegmng.entity.Doctor;
import com.olegmng.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

//    public List<Doctor> getAllDoctors() {
//        doctorRepository.save(new Doctor("Usikov", "surgery", 11L, "MedCity"));
//        doctorRepository.save(new Doctor("Kirpichnikova", "therapist", 15L, "Family"));
//        doctorRepository.save(new Doctor("Salimov", "ent", 7L, "Medsi"));
//        doctorRepository.save(new Doctor("Polevoi", "dentist", 21L, "MedSwiss"));
//
//        return doctorRepository.findAll();
//    }

        public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
    public List<Doctor> saveDoctor(DoctorDTO doctor){
        doctorRepository.save(new Doctor(
                doctor.getDoctor().getLastName(), doctor.getDoctor().getDirection(),
                doctor.getDoctor().getExperience(), doctor.getDoctor().getClinic()));

        return doctorRepository.findAll();
    }
    public Optional<Doctor> getDoctorById(Long id){
        return doctorRepository.findById(id);
    }

    public List<Doctor> deleteDoctorById(Long id) {
        doctorRepository.deleteById(id);
        return doctorRepository.findAll();
    }
}
