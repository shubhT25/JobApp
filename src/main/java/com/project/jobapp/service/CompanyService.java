package com.project.jobapp.service;

import com.project.jobapp.dto.Company;

import com.project.jobapp.repository.CompanyRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private static final Logger log = LoggerFactory.getLogger(CompanyService.class);
    CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    //    private List<company> companys = new ArrayList<>();
    private long id = 1L;

    public List<Company> findAllCompanies(){
        log.info("Listing Companies");
        return companyRepository.findAll();
    }
    public String createCompany(@RequestBody Company company){
        company.setId(id++);
        log.info("Save the company" + company.getName());
        companyRepository.save(company);
        return "company added";
    }

    public Company getCompanyById(Long id) {
        return (Company) companyRepository.findById(id).orElse(null);
    }

    public String deleteCompanyById(Long id) {
        try {
            companyRepository.deleteById(id);
            return "success";
        } catch (Exception e) {
            return null;
        }
    }

    public String updateCompanyById(Long id, Company updatecompany) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()) {
            Company company = companyOptional.get();
            company.setId(updatecompany.getId());
            company.setDescription(updatecompany.getDescription());
            company.setName(updatecompany.getName());
            company.setJobs(updatecompany.getJobs());
            companyRepository.save(company);
            return "success";
        }
        return null;
    }
}
