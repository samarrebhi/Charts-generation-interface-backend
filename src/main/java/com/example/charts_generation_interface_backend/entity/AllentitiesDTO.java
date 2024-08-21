package com.example.charts_generation_interface_backend.entity;


import java.util.List;





public class AllentitiesDTO {
    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    private List<Sale> sales;
    private List<Customer> customers;
    private List<Product> products;
    private List<Store> stores;

    // Getters and setters
}
