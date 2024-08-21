package com.example.charts_generation_interface_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Builder
@Table(name="Products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;


    private String productName;
    private String category;
    private float price;
}
