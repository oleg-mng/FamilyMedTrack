package com.olegmng.repository;


import com.olegmng.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    @Query("select r.type from Report r where r.report_id = (:id)")
    String findTypeReportById(Long id);
}
