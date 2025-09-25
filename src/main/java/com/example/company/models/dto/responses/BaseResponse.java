package com.example.company.models.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {
    private int id;
    private Instant createdAt;
    private Instant updatedAt;
    private boolean isActive;
    private boolean isDeleted;
}
