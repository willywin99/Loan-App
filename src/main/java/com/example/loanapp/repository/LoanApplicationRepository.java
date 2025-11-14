package com.example.loanapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.loanapp.entity.LoanApplication;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {
}
