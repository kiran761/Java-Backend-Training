package com.example.FeignProductService.service;

import com.example.FeignProductService.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    List<Product> findByCategory(String category);
    Product findById(int id);
}
