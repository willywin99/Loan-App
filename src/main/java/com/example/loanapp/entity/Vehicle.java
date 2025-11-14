package com.example.loanapp.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String merk;
    private String model;
    private String tipe;
    private String warna;
    private BigDecimal harga;

    public Vehicle() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getMerk() { return merk; }
    public void setMerk(String merk) { this.merk = merk; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public String getTipe() { return tipe; }
    public void setTipe(String tipe) { this.tipe = tipe; }
    public String getWarna() { return warna; }
    public void setWarna(String warna) { this.warna = warna; }
    public BigDecimal getHarga() { return harga; }
    public void setHarga(BigDecimal harga) { this.harga = harga; }
}
