package com.example.demo.controller;

import com.example.demo.exceptions.InvalidInputException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;

    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable int productId) {
            LOG.debug("/product/{productId} called with productId={}", productId);
            Product product = productService.getProduct(productId);
            return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
