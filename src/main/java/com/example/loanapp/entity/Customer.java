package com.example.loanapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nama;
    private String ktp;
    private String alamat;
    private String telp;

    public Customer() {}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getKtp() { return ktp; }
    public void setKtp(String ktp) { this.ktp = ktp; }
    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
    public String getTelp() { return telp; }
    public void setTelp(String telp) { this.telp = telp; }
}
