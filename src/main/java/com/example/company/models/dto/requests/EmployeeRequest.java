package com.example.company.models.dto.requests;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class EmployeeRequest extends BaseRequest {
    @NotBlank(message = "Employee name must be not blank!")
    private String name;

    @NotNull(message = "Salary id must be not null!")
    @Min(value = 0, message = "Salary must be greater than or equal to 0!")
    @Max(value = 100000000, message = "Salary must be less than or equal to 100,000,000!")
    private Double salary;

    @NotNull(message = "Department id must be not null!")
    private int departmentId;
}
