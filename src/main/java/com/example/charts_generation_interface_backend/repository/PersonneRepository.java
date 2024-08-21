package com.example.charts_generation_interface_backend.repository;


import com.example.charts_generation_interface_backend.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne,Integer> {
}
