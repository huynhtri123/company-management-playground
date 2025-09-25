package com.example.company.models.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseRequest {
    private boolean isActive = true;
    private boolean isDeleted = false;
}
