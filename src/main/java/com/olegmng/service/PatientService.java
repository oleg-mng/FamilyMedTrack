package com.olegmng.service;

import com.olegmng.entity.Patient;
import com.olegmng.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


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
}
