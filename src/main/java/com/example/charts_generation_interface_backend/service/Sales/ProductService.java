package com.example.charts_generation_interface_backend.service.Sales;

import com.example.charts_generation_interface_backend.entity.Customer;
import com.example.charts_generation_interface_backend.entity.Product;
import com.example.charts_generation_interface_backend.repository.CustomerRepo;
import com.example.charts_generation_interface_backend.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getallProducts() {
        return productRepo.findAll();
    }
}
