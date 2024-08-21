package com.example.charts_generation_interface_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Builder
@Table(name="Sales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sale implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int saleId;
    private LocalDate saleDate;
    private int quantity;
    private float totalAmount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
