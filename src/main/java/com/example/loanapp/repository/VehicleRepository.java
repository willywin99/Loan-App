package com.example.loanapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.loanapp.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {}
