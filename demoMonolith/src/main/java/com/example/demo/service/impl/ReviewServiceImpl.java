package com.example.demo.service.impl;

import com.example.demo.exceptions.InvalidInputException;
import com.example.demo.model.Product;
import com.example.demo.model.Review;
import com.example.demo.service.ProductService;
import com.example.demo.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReviewServiceImpl implements ReviewService {
    private final ProductService productService;
    private static final Logger LOG = LoggerFactory.getLogger(ReviewServiceImpl.class);


    @Autowired
    public ReviewServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<Review> getReviews(int productId) {
        Product product = productService.getProduct(productId);
        int prodId = product.getProductId();


        List<Review> list = new ArrayList<>();
        list.add(new Review(prodId, 1, "Author 1", "Subject 1", "Content 1"));
        list.add(new Review(prodId, 2, "Author 2", "Subject 2", "Content 2"));
        list.add(new Review(prodId, 3, "Author 3", "Subject 3", "Content 3"));

        LOG.debug("/reviews response size: {}", list.size());

        return list;
    }
}
