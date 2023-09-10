package com.example.demomonolithgraddle.service;

import com.example.demomonolithgraddle.model.Product;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {
    Product getProduct(@PathVariable int productId);
}