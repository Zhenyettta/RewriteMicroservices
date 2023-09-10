package com.example.productservice.service;



import com.example.productservice.model.Product;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {
    Product getProduct(@PathVariable int productId);
}