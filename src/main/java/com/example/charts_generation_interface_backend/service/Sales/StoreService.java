package com.example.charts_generation_interface_backend.service.Sales;

import com.example.charts_generation_interface_backend.entity.Sale;
import com.example.charts_generation_interface_backend.entity.Store;
import com.example.charts_generation_interface_backend.repository.SaleRepo;
import com.example.charts_generation_interface_backend.repository.StoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {


    @Autowired
    private StoreRepo storeRepo;

    public List<Store> getAllStores() {
        return storeRepo.findAll();
    }
}
