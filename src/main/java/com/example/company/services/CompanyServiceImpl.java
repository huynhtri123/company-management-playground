package com.example.company.services;

import com.example.company.commons.PageResponse;
import com.example.company.exceptions.CustomException;
import com.example.company.models.dto.requests.CompanyRequest;
import com.example.company.models.dto.responses.CompanyResponse;
import com.example.company.models.entity.Company;
import com.example.company.repositories.CompanyRepository;
import com.example.company.utils.mappers.CompanyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public CompanyResponse create(CompanyRequest companyRequest) {
        if (companyRepository.existsByName(companyRequest.getName())) {
            throw new CustomException(409, "Company name already exists");
        }
        Company company = companyMapper.convertToEntity(companyRequest);
        return companyMapper.convertToResponse(
                companyRepository.save(company)
        );
    }

    @Override
    public List<CompanyResponse> getAll() {
        return companyRepository.getAll().stream()
                .map(companyMapper::convertToResponse)
                .toList();
    }

    @Override
    public CompanyResponse update(int id, CompanyRequest companyRequest) {
        if (companyRepository.findById(id).isEmpty()) {
            throw new CustomException(404, "Company not found");
        }
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new CustomException(404, "Company not found"));
        company.setName(companyRequest.getName());
        return companyMapper.convertToResponse(companyRepository.save(company));
    }
}
