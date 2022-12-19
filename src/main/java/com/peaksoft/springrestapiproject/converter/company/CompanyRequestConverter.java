package com.peaksoft.springrestapiproject.converter.company;

import com.peaksoft.springrestapiproject.dto.request.CompanyRequest;
import com.peaksoft.springrestapiproject.entities.Company;
import org.springframework.stereotype.Component;
@Component
public class CompanyRequestConverter  {
    public Company createCompany (CompanyRequest companyRequest){
        if (companyRequest == null){
            return null;
        }
        Company company = new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        return company;
    }
    public void updateCompany (Company company,CompanyRequest companyRequest){
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
    }
}
