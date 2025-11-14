package com.example.loanapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.loanapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
