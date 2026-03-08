package com.embarkx.firstJobapp.company.impl;

import com.embarkx.firstJobapp.company.Company;
import com.embarkx.firstJobapp.company.CompanyController;
import com.embarkx.firstJobapp.company.CompanyRepository;
import com.embarkx.firstJobapp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository=companyRepository;
    }


    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> updateCompany = companyRepository.findById(id);
        if(updateCompany.isPresent()){
           Company updateToCompany = updateCompany.get();
           updateToCompany.setName(company.getName());
           updateToCompany.setDescription(company.getDescription());
           updateToCompany.setJobs(company.getJobs());
           companyRepository.save(updateToCompany);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }


}
