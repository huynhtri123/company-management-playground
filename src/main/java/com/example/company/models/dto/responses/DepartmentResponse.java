package com.example.company.models.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponse extends BaseResponse {
    private String name;
    private CompanyResponse company;
    private List<EmployeeResponse> employees;
}
