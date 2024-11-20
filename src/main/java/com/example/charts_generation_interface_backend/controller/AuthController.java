package com.example.charts_generation_interface_backend.controller;


import com.example.charts_generation_interface_backend.entity.User;
import com.example.charts_generation_interface_backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")

@CrossOrigin(origins = "*")

public class AuthController {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        // Check if the username already exists
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            // Return an error response in JSON format
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Username already exists");
            errorResponse.put("status", "failure");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }

        // Encode the password before saving the user
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        // Return a success response in JSON format
        Map<String, String> successResponse = new HashMap<>();
        successResponse.put("message", "User created successfully");
        successResponse.put("status", "success");

        return ResponseEntity.status(HttpStatus.CREATED).body(successResponse);
    }



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent() && passwordEncoder.matches(user.getPassword(), existingUser.get().getPassword())) {
            // Creating a response map with message and status
            Map<String, String> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("status", "success");

            // Return the response as a JSON object
            return ResponseEntity.ok(response);
        }

        // Return an error response if the login fails
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", "Invalid username or password");
        errorResponse.put("status", "failure");

        return ResponseEntity.status(401).body(errorResponse); // Unauthorized
    }
}
