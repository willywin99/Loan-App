package com.example.loanapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.loanapp.entity.Vehicle;
import com.example.loanapp.repository.VehicleRepository;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleRepository repo;

    public VehicleController(VehicleRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Vehicle> listAll() {
        return repo.findAll();
    }
}
