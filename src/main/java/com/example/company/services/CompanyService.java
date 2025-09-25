package com.example.company.services;

import com.example.company.commons.PageResponse;
import com.example.company.models.dto.requests.CompanyRequest;
import com.example.company.models.dto.responses.CompanyResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CompanyService {
    public CompanyResponse create(CompanyRequest companyRequest);
    public List<CompanyResponse> getAll();
    public CompanyResponse update(int id, CompanyRequest companyRequest);
    public Page<CompanyResponse> getAllPageable(int pageNo, int pageSize);
    public PageResponse<CompanyResponse> getAllPageableCustom(int pageNo, int pageSize);
    public String toggleSoftDelete(int companyId, boolean isSoftDelete);
    public CompanyResponse forceDelete(int companyId);
}
