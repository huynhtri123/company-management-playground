package com.example.company.models.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequest extends BaseRequest {
    @NotBlank(message = "Department name must be not blank!")
    private String name;
    @NotNull(message = "Company id must be not null!")
    private int companyId;
}
