
package com.peaksoft.springrestapiproject.controller;

import com.peaksoft.springrestapiproject.dto.request.CompanyRequest;
import com.peaksoft.springrestapiproject.dto.responce.CompanyResponse;
import com.peaksoft.springrestapiproject.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/getAll")
    public List<CompanyResponse> getAllCompany(){
        return companyService.getAllCompanies();
    }

    @PostMapping()
    public CompanyResponse saveCompany(@RequestBody CompanyRequest companyRequest) throws IOException {
        return companyService.addCompany(companyRequest);
    }

    @GetMapping("/findById/{id}")
    public CompanyResponse findById(@PathVariable Long id){
        return companyService.getCompanyById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public CompanyResponse deleteById(@PathVariable Long id){
        return companyService.deleteCompany(id);
    }

    @PutMapping("/update/{id}")
    public CompanyResponse updateCompany(@PathVariable Long id, @RequestBody CompanyRequest companyRequest) throws IOException {
        return companyService.updateCompany(id, companyRequest);
    }


}
