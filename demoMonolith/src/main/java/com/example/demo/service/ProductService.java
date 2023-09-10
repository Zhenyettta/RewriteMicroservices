package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {
    Product getProduct(@PathVariable int productId);
}