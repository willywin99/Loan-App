package com.example.loanapp.dto;

import java.math.BigDecimal;

public class ApplicationRequestDto {
    private Long customerId;
    private Long vehicleId;
    private BigDecimal hargaKendaraan;
    private BigDecimal downPayment;
    private Integer tenorBulan;
    private BigDecimal bungaPercent;
    private String createdBy;

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }
    public BigDecimal getHargaKendaraan() { return hargaKendaraan; }
    public void setHargaKendaraan(BigDecimal hargaKendaraan) { this.hargaKendaraan = hargaKendaraan; }
    public BigDecimal getDownPayment() { return downPayment; }
    public void setDownPayment(BigDecimal downPayment) { this.downPayment = downPayment; }
    public Integer getTenorBulan() { return tenorBulan; }
    public void setTenorBulan(Integer tenorBulan) { this.tenorBulan = tenorBulan; }
    public BigDecimal getBungaPercent() { return bungaPercent; }
    public void setBungaPercent(BigDecimal bungaPercent) { this.bungaPercent = bungaPercent; }
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
}
