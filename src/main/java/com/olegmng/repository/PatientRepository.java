package com.olegmng.repository;

import com.olegmng.dto.PatientDTO;
import com.olegmng.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
