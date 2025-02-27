package com.project.jobapp.repository;

import com.project.jobapp.dto.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {


}
