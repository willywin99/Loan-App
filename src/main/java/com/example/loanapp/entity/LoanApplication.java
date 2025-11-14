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
    private String status;

    private String createdBy;
    private LocalDateTime createdDate;
    private String approvedBy;
    private LocalDateTime approvedDate;
    @Column(length=1000)
    private String notes;

    public LoanApplication() {}

    // getters/setters below
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public java.math.BigDecimal getHargaKendaraan() { return hargaKendaraan; }
    public void setHargaKendaraan(java.math.BigDecimal hargaKendaraan) { this.hargaKendaraan = hargaKendaraan; }
    public java.math.BigDecimal getDownPayment() { return downPayment; }
    public void setDownPayment(java.math.BigDecimal downPayment) { this.downPayment = downPayment; }
    public Integer getTenorBulan() { return tenorBulan; }
    public void setTenorBulan(Integer tenorBulan) { this.tenorBulan = tenorBulan; }
    public java.math.BigDecimal getBungaPercent() { return bungaPercent; }
    public void setBungaPercent(java.math.BigDecimal bungaPercent) { this.bungaPercent = bungaPercent; }
    public java.math.BigDecimal getTotalPinjaman() { return totalPinjaman; }
    public void setTotalPinjaman(java.math.BigDecimal totalPinjaman) { this.totalPinjaman = totalPinjaman; }
    public java.math.BigDecimal getAngsuranPerBulan() { return angsuranPerBulan; }
    public void setAngsuranPerBulan(java.math.BigDecimal angsuranPerBulan) { this.angsuranPerBulan = angsuranPerBulan; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    public java.time.LocalDateTime getCreatedDate() { return createdDate; }
    public void setCreatedDate(java.time.LocalDateTime createdDate) { this.createdDate = createdDate; }
    public String getApprovedBy() { return approvedBy; }
    public void setApprovedBy(String approvedBy) { this.approvedBy = approvedBy; }
    public java.time.LocalDateTime getApprovedDate() { return approvedDate; }
    public void setApprovedDate(java.time.LocalDateTime approvedDate) { this.approvedDate = approvedDate; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
