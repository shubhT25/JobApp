package com.project.jobapp.service;

import com.project.jobapp.dto.Job;
import com.project.jobapp.repository.JobRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    JobRepository jobRepository;
    public JobService(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

//    private List<Job> jobs = new ArrayList<>();
    private long id = 1L;

    public List<Job> findAll(){
        return jobRepository.findAll();
    }
    public String createJob(@RequestBody Job job){
        job.setId(id++);
        jobRepository.save(job);
        return "job added";
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    public String deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return "success";
        } catch (Exception e) {
            return null;
        }
    }

    public String updateJobById(Long id, Job updateJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setId(updateJob.getId());
            job.setTitle(updateJob.getTitle());
            job.setDescription(updateJob.getDescription());
            job.setMaxSalary(updateJob.getMaxSalary());
            job.setMinSalary(updateJob.getMinSalary());
            job.setLocation(updateJob.getLocation());
            jobRepository.save(job);
            return "success";
        }
        return null;
    }
}
