package com.example.company.controllers;

import com.example.company.commons.BaseResponseObj;
import com.example.company.models.dto.requests.CompanyRequest;
import com.example.company.services.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping("/")
    public ResponseEntity<BaseResponseObj> create(@RequestBody @Valid CompanyRequest companyRequest) {
        return ResponseEntity.ok(
                new BaseResponseObj(201, companyService.create(companyRequest), "Created company successfully")
        );
    }

    @GetMapping("/")
    public ResponseEntity<BaseResponseObj> getAll() {
        return ResponseEntity.ok(
                new BaseResponseObj(200, companyService.getAll(), "All company successfully")
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponseObj> update(@PathVariable("id") int id, @RequestBody @Valid CompanyRequest companyRequest) {
        return ResponseEntity.ok(
                new BaseResponseObj(200, companyService.update(id, companyRequest), "Updated company successfully")
        );
    }
}
