package com.olegmng.service;

import com.olegmng.entity.SecurityPatient;
import com.olegmng.repository.PatientRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
//public class PatientDetailsService implements UserDetailsService {
//    private final PatientRepository patientRepository;
//
//    public PatientDetailsService(PatientRepository patientRepository) {
//        this.patientRepository = patientRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return patientRepository
//                .findByPatientName(username)
//                .map(SecurityPatient::new)
//                .orElseThrow(() -> new UsernameNotFoundException("Patient not found "+username));
//
//    }
//}
