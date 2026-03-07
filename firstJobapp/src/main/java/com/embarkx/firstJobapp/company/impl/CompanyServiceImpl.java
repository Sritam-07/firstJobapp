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
    public boolean updatedCompany(Company company, long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company companyTOUpdate = companyOptional.get();
            companyTOUpdate.setDescription(company.getDescription());
            companyTOUpdate.setJobs(company.getJobs());
            companyTOUpdate.setName(company.getName());
            companyRepository.save(companyTOUpdate);
            return true;
        }
        else{
            return false;
        }
    }


}
