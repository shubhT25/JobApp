package com.project.jobapp.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Jobs")
public class Job {
    @Id
    private long id;
    private String title;
    private String description;
    private float maxSalary;
    private float minSalary;
    private String location;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", nullable = false)
    @JsonBackReference
    private Company company;

    public Job() {

    }

    public Job(long id, String title, String description, String location, float maxSalary, float minSalary, Company company) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.maxSalary = maxSalary;
        this.minSalary = minSalary;
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(float maxSalary) {
        this.maxSalary = maxSalary;
    }

    public float getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(float minSalary) {
        this.minSalary = minSalary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
