package com.embarkx.firstJobapp.company;

import org.springframework.stereotype.Service;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
   public boolean updateCompany(Company company,Long id);
   void createCompany(Company company);
}
