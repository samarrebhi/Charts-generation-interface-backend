package com.example.charts_generation_interface_backend.service.Sales;

import com.example.charts_generation_interface_backend.entity.Customer;
import com.example.charts_generation_interface_backend.entity.Sale;
import com.example.charts_generation_interface_backend.repository.CustomerRepo;
import com.example.charts_generation_interface_backend.repository.SaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }
}
