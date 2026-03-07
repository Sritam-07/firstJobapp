package com.embarkx.firstJobapp.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
   private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping()
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @PutMapping("/companies/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company company){
        boolean updated = companyService.updatedCompany(company, id);
        if(updated){
            return new ResponseEntity<>("Company Updated Successfuly" , HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Company Not Found! with id: "+id+".",HttpStatus.NOT_FOUND);
        }
    }
}
