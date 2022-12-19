
package com.peaksoft.springrestapiproject.service;



import com.peaksoft.springrestapiproject.dto.request.CompanyRequest;
import com.peaksoft.springrestapiproject.dto.responce.CompanyResponse;

import java.util.List;
public interface CompanyService {
    List<CompanyResponse> getAllCompanies();

    CompanyResponse addCompany(CompanyRequest company);

    CompanyResponse getCompanyById(Long id);


    CompanyResponse deleteCompany(Long id);

    CompanyResponse updateCompany(Long id, CompanyRequest companyRequest);
}
