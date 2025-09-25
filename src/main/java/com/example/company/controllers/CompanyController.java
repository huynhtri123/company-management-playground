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

    @GetMapping("/pageable")
    public ResponseEntity<BaseResponseObj> getAllPageable(@RequestParam("pageNo") int pageNo,
                                                          @RequestParam("pageSize") int pageSize) {
        return ResponseEntity.ok(
                new BaseResponseObj(200, companyService.getAllPageable(pageNo, pageSize), "All page successfully")
        );
    }

    @GetMapping("/pageable-custom")
    public ResponseEntity<BaseResponseObj> getAllPageableCustom(@RequestParam("pageNo") int pageNo,
                                                           @RequestParam("pageSize") int pageSize) {
        return ResponseEntity.ok(
                new BaseResponseObj(200,
                        companyService.getAllPageableCustom(pageNo, pageSize),
                        "All page successfully")
        );
    }

    @PatchMapping("/soft-delete/{id}")
    public ResponseEntity<BaseResponseObj> softDelete(@PathVariable("id") int id) {
        boolean isNewSoftDelete = true;
        return ResponseEntity.ok(
                new BaseResponseObj(200, null, companyService.toggleSoftDelete(id, isNewSoftDelete))
        );
    }

    @PatchMapping("/restore/{id}")
    public ResponseEntity<BaseResponseObj> restore(@PathVariable("id") int id) {
        boolean isNewSoftDelete = false;
        return ResponseEntity.ok(
                new BaseResponseObj(200, null, companyService.toggleSoftDelete(id, isNewSoftDelete))
        );
    }

    @DeleteMapping("/force-delete/{id}")
    public ResponseEntity<BaseResponseObj> forceDelete(@PathVariable("id") int id) {
        return ResponseEntity.ok(
                new BaseResponseObj(200, companyService.forceDelete(id), "Force deleted successfully")
        );
    }

}
