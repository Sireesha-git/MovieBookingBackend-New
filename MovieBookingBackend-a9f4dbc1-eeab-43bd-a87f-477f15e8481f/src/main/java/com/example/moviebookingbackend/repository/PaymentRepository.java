package com.example.moviebookingbackend.repository;

import com.example.moviebookingbackend.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
}