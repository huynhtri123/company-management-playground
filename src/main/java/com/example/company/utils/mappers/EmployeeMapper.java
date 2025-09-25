package com.example.company.utils.mappers;

import com.example.company.models.dto.responses.EmployeeResponse;
import com.example.company.models.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {
    private final ModelMapper mapper;

    public EmployeeResponse convertToResponse(Employee employee) {
        return mapper.map(employee, EmployeeResponse.class);
    }

    public Employee convertToEntity(EmployeeResponse employeeResponse) {
        return mapper.map(employeeResponse, Employee.class);
    }

}
