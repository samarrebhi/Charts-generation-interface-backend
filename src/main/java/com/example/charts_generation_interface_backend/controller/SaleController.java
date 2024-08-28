package com.example.charts_generation_interface_backend.controller;



import com.example.charts_generation_interface_backend.entity.Sale;
import com.example.charts_generation_interface_backend.service.Sales.CustomerService;
import com.example.charts_generation_interface_backend.service.Sales.ProductService;
import com.example.charts_generation_interface_backend.service.Sales.SaleService;
import com.example.charts_generation_interface_backend.service.Sales.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sales")
@CrossOrigin(origins = "*")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @GetMapping("/getsales")
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }
    
    
    ////////////get all entities

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private StoreService storeService;

    @GetMapping("/getallentities")
    public List<Object> getAllEntities() {
        List<Object> allEntities = new ArrayList<>();


        allEntities.addAll(saleService.getAllSales());

        allEntities.addAll(customerService.getAllCustomers());

        allEntities.addAll(productService.getallProducts());

        allEntities.addAll(storeService.getAllStores());

        return allEntities;
    }
    //////for the sql query
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @PostMapping("/executeSql")
    public ResponseEntity<List<Map<String, Object>>> executeSql(@RequestBody String sqlQuery) {
        List<Map<String, Object>> results = jdbcTemplate.queryForList(sqlQuery);
        return ResponseEntity.ok(results);
    }
}

