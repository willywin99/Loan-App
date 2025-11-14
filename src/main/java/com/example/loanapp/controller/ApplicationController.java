package com.example.loanapp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.loanapp.entity.LoanApplication;
import com.example.loanapp.dto.ApplicationRequestDto;
import com.example.loanapp.dto.ApproveRequestDto;
import com.example.loanapp.repository.LoanApplicationRepository;
import com.example.loanapp.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    private final ApplicationService service;
    private final LoanApplicationRepository repo;

    public ApplicationController(ApplicationService service, LoanApplicationRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    @PreAuthorize("hasAnyRole('SALES', 'APPROVER')")
    @GetMapping
    public List<LoanApplication> listAll() {
        return repo.findAll();
    }

    @PreAuthorize("hasAnyRole('SALES', 'APPROVER')")
    @GetMapping("/{id}")
    public ResponseEntity<LoanApplication> getOne(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('SALES')")
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ApplicationRequestDto req, Principal p) {
        String username = p != null ? p.getName() : req.getCreatedBy();
        try {
            LoanApplication app = service.createAndSubmit(req.getCustomerId(), req.getVehicleId(),
                    req.getHargaKendaraan(), req.getDownPayment(), req.getTenorBulan(), req.getBungaPercent(), username);
            return ResponseEntity.status(201).body(app);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(java.util.Map.of("error", ex.getMessage()));
        }
    }

    @PreAuthorize("hasRole('APPROVER')")
    @PostMapping("/{id}/approve")
    public ResponseEntity<?> approve(@PathVariable Long id, Principal p) {
        String approver = p != null ? p.getName() : "system";
        try {
            LoanApplication a = service.approve(id, approver);
            return ResponseEntity.ok(a);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(java.util.Map.of("error", ex.getMessage()));
        }
    }

    @PreAuthorize("hasRole('APPROVER')")
    @PostMapping("/{id}/reject")
    public ResponseEntity<?> reject(@PathVariable Long id, @RequestBody ApproveRequestDto dto, Principal p) {
        String approver = p != null ? p.getName() : "system";
        try {
            LoanApplication a = service.reject(id, approver, dto.getReason());
            return ResponseEntity.ok(a);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(java.util.Map.of("error", ex.getMessage()));
        }
    }
}
