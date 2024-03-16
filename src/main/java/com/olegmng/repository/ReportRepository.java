package com.olegmng.repository;

import com.olegmng.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
//    @Query("SELECT patient.login FROM patient WHERE patient.patient_id = (:id)")
//    List<String> showLogin(long id);
}
