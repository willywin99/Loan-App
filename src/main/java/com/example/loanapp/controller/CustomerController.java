package com.example.loanapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.loanapp.entity.Customer;
import com.example.loanapp.repository.CustomerRepository;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerRepository repo;

    public CustomerController(CustomerRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Customer> listAll() {
        return repo.findAll();
    }
}
