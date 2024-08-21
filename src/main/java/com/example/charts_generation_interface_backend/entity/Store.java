package com.example.charts_generation_interface_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;



@Entity
@Builder
@Table(name="Stores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Store implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storeId;
    private String storeName;
    private String location;

}
