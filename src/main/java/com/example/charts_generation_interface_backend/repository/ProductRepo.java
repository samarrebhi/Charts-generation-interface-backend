package com.example.charts_generation_interface_backend.repository;


import com.example.charts_generation_interface_backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer>
 {}
