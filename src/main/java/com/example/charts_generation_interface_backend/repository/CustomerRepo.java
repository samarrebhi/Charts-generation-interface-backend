package com.example.charts_generation_interface_backend.repository;


import com.example.charts_generation_interface_backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {}

