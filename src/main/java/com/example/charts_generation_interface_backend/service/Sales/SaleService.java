package com.example.charts_generation_interface_backend.service.Sales;

import com.example.charts_generation_interface_backend.entity.Sale;
import com.example.charts_generation_interface_backend.repository.SaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleRepo saleRepository;

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }
}