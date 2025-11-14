package com.example.loanapp.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "loan_applications")
public class LoanApplication {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(optional = false)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private BigDecimal hargaKendaraan;
    private BigDecimal downPayment;
    private Integer tenorBulan;
    private BigDecimal bungaPercent;
    private BigDecimal totalPinjaman;
    private BigDecimal angsuranPerBulan;

    @Column(length=30)
    private String status; // draft, submitted, pending_approval, approved, rejected

    private String createdBy;
    private LocalDateTime createdDate;
    private String approvedBy;
    private LocalDateTime approvedDate;
    @Column(length=1000)
    private String notes;

    public LoanApplication() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

    public BigDecimal getHargaKendaraan() { return hargaKendaraan; }
    public void setHargaKendaraan(BigDecimal hargaKendaraan) { this.hargaKendaraan = hargaKendaraan; }
    public BigDecimal getDownPayment() { return downPayment; }
    public void setDownPayment(BigDecimal downPayment) { this.downPayment = downPayment; }
    public Integer getTenorBulan() { return tenorBulan; }
    public void setTenorBulan(Integer tenorBulan) { this.tenorBulan = tenorBulan; }
    public BigDecimal getBungaPercent() { return bungaPercent; }
    public void setBungaPercent(BigDecimal bungaPercent) { this.bungaPercent = bungaPercent; }
    public BigDecimal getTotalPinjaman() { return totalPinjaman; }
    public void setTotalPinjaman(BigDecimal totalPinjaman) { this.totalPinjaman = totalPinjaman; }
    public BigDecimal getAngsuranPerBulan() { return angsuranPerBulan; }
    public void setAngsuranPerBulan(BigDecimal angsuranPerBulan) { this.angsuranPerBulan = angsuranPerBulan; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    public LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(LocalDateTime createdDate) { this.createdDate = createdDate; }
    public String getApprovedBy() { return approvedBy; }
    public void setApprovedBy(String approvedBy) { this.approvedBy = approvedBy; }
    public LocalDateTime getApprovedDate() { return approvedDate; }
    public void setApprovedDate(LocalDateTime approvedDate) { this.approvedDate = approvedDate; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
