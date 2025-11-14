package com.example.loanapp.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.loanapp.entity.*;
import com.example.loanapp.repository.*;

@Service
public class ApplicationService {
    private final LoanApplicationRepository appRepo;
    private final CustomerRepository customerRepo;
    private final VehicleRepository vehicleRepo;

    public ApplicationService(LoanApplicationRepository appRepo, CustomerRepository customerRepo, VehicleRepository vehicleRepo) {
        this.appRepo = appRepo;
        this.customerRepo = customerRepo;
        this.vehicleRepo = vehicleRepo;
    }

    @Transactional
    public LoanApplication createAndSubmit(Long customerId, Long vehicleId, BigDecimal hargaKendaraan,
            BigDecimal downPayment, Integer tenorBulan, BigDecimal bungaPercent, String createdBy) {

        Customer cust = customerRepo.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        Vehicle veh = vehicleRepo.findById(vehicleId).orElseThrow(() -> new RuntimeException("Vehicle not found"));

        BigDecimal totalPinjam = hargaKendaraan.subtract(downPayment);
        BigDecimal bungaFraction = bungaPercent.divide(BigDecimal.valueOf(100));
        BigDecimal totalWithInterest = totalPinjam.multiply(BigDecimal.ONE.add(bungaFraction.multiply(BigDecimal.valueOf(tenorBulan).divide(BigDecimal.valueOf(12)))));
        BigDecimal angsuran = totalWithInterest.divide(BigDecimal.valueOf(tenorBulan), 2, BigDecimal.ROUND_HALF_UP);

        LoanApplication app = new LoanApplication();
        app.setCustomer(cust);
        app.setVehicle(veh);
        app.setHargaKendaraan(hargaKendaraan);
        app.setDownPayment(downPayment);
        app.setTenorBulan(tenorBulan);
        app.setBungaPercent(bungaPercent);
        app.setTotalPinjaman(totalWithInterest);
        app.setAngsuranPerBulan(angsuran);
        app.setStatus("submitted");
        app.setCreatedBy(createdBy);
        app.setCreatedDate(LocalDateTime.now());
        return appRepo.save(app);
    }

    @Transactional
    public LoanApplication approve(Long appId, String approver) {
        LoanApplication app = appRepo.findById(appId).orElseThrow(() -> new RuntimeException("Not found"));
        if ("approved".equalsIgnoreCase(app.getStatus())) throw new RuntimeException("Already approved");
        app.setStatus("approved");
        app.setApprovedBy(approver);
        app.setApprovedDate(LocalDateTime.now());
        return appRepo.save(app);
    }

    @Transactional
    public LoanApplication reject(Long appId, String approver, String reason) {
        LoanApplication app = appRepo.findById(appId).orElseThrow(() -> new RuntimeException("Not found"));
        app.setStatus("rejected");
        app.setApprovedBy(approver);
        app.setApprovedDate(LocalDateTime.now());
        app.setNotes(reason);
        return appRepo.save(app);
    }
}
