package com.example.company.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass   // nói với Hibernate rằng class này không có table riêng,
                    // nhưng các field sẽ được thêm vào bảng của entity con.
public abstract class BaseEntity {  // abstract: tránh việc JPA cố gắng tạo một entity/table
    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;

    private boolean isActive = true;
    private boolean isDeleted = false;
}
