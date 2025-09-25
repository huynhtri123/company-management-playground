package com.example.company.repositories;

import com.example.company.models.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    public boolean existsByName(String name);

    @Query(value = "SELECT c FROM Company c WHERE c.isActive = true AND c.isDeleted = false")
    public List<Company> getAllActive();

    @Query(value = "SELECT c FROM Company c WHERE c.isActive = true AND c.isDeleted = false")
    public Page<Company> getAllActivePage(Pageable pageable);

}
