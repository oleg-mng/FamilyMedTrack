package com.olegmng.repository;

import com.olegmng.dto.ReportDTO;
import com.olegmng.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

//    @Query("SELECT patient.login FROM patient WHERE patient.patient_id = (:id)")
//    List<String> showLogin(long id);

//    @Query("SELECT * FROM Report r"+
//            "INNER JOIN Patient p ON" +
//            "r.patient_id = p.patient_id and r.patient_id = (:id)")

//
//    List<Report> findReportByPatientId(Long id);
}
