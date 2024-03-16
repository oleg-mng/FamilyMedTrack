package com.olegmng.service;

import com.olegmng.entity.Doctor;
import com.olegmng.entity.Patient;
import com.olegmng.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        patientRepository.save(new Patient("Vika", "p1"));
        patientRepository.save(new Patient("Anna", "p2"));
        patientRepository.save(new Patient("Natalia", "p3"));
        patientRepository.save(new Patient("Oleg", "p4"));

        return patientRepository.findAll();
    }

    public List<Patient> savePatient(Patient patient){
        patientRepository.save(new Patient(
                patient.getLogin(), patient.getPassword()));

        return patientRepository.findAll();
    }
    public Optional<Patient> getPatientById(Long id){
        return patientRepository.findById(id);
    }
}
