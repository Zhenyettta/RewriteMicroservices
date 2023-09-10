package com.example.demomonolithgradle.service;


import com.example.demomonolithgradle.model.Product;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {
    Product getProduct(@PathVariable int productId);
}