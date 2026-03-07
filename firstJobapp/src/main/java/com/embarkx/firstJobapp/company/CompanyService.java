package com.embarkx.firstJobapp.company;

import org.springframework.stereotype.Service;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updatedCompany(Company company,long id);
}
