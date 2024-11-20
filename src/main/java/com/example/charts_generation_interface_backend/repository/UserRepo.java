package com.example.charts_generation_interface_backend.repository;

import com.example.charts_generation_interface_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);}
