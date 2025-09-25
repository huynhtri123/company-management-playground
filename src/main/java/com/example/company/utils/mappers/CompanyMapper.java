package com.example.company.utils.mappers;

import com.example.company.models.dto.requests.CompanyRequest;
import com.example.company.models.dto.responses.CompanyResponse;
import com.example.company.models.dto.responses.DepartmentResponse;
import com.example.company.models.entity.Company;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CompanyMapper {

    private final ModelMapper mapper;
    private final DepartmentMapper departmentMapper;

    public Company convertToEntity(CompanyRequest companyRequest) {
        return mapper.map(companyRequest, Company.class);
    }

    public CompanyResponse convertToResponse(Company company) {
        CompanyResponse companyResponse = mapper.map(company, CompanyResponse.class);
        if (company.getDepartments() != null) {
            List<DepartmentResponse> departments = company.getDepartments()
                    .stream().map(departmentMapper::toResponse)
                    .toList();
            companyResponse.setDepartments(departments);
        }
        return companyResponse;
    }
}
