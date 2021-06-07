package com.AlbertAbuav.Test05.repositories;

import com.AlbertAbuav.Test05.beans.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    Job findByEndDate(java.sql.Date endDate);
    List<Job> findByEndDateBetween(java.sql.Date startDate, java.sql.Date endDate);
}
