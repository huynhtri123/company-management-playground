package com.example.company.utils.mappers;

import com.example.company.models.dto.responses.DepartmentResponse;
import com.example.company.models.entity.Department;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DepartmentMapper {
    private final ModelMapper modelMapper;

    public DepartmentResponse toResponse(Department department) {
        return modelMapper.map(department, DepartmentResponse.class);
    }

    public Department toEntity(DepartmentResponse departmentResponse) {
        return modelMapper.map(departmentResponse, Department.class);
    }
}
