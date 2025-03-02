package com.project.jobapp.controllers;

import com.project.jobapp.dto.Company;
import com.project.jobapp.dto.Job;
import com.project.jobapp.service.CompanyService;
import com.project.jobapp.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public ResponseEntity<List<Company>> findAll(){
        return ResponseEntity.ok(companyService.findAllCompanies());
    }

    @PostMapping("/companies")
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        System.out.println("Post method");
        companyService.createCompany(company);
        return new ResponseEntity<>("Company Created Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/company/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id) {
        String message = companyService.deleteCompanyById(id);
        if(Objects.equals(message, "success")){
            return new ResponseEntity<>("Company Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/company/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Company updateCompany) {
        String message = companyService.updateCompanyById(id, updateCompany);
        if(Objects.equals(message, "success")){
            return new ResponseEntity<>("Company Updated", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
