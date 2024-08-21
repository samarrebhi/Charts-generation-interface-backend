package com.example.charts_generation_interface_backend.repository;



import com.example.charts_generation_interface_backend.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepo extends JpaRepository<Sale, Integer> {}

