package com.example.reviewservice.service.impl;


import com.example.reviewservice.exceptions.InvalidInputException;
import com.example.reviewservice.exceptions.NotFoundException;
import com.example.reviewservice.model.Product;
import com.example.reviewservice.model.Review;
import com.example.reviewservice.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ReviewServiceImpl implements ReviewService {

    private static final Logger LOG = LoggerFactory.getLogger(ReviewServiceImpl.class);

    private final RestTemplate restTemplate;

    @Autowired
    public ReviewServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public List<Review> getReviews(int productId) {
        if (productId < 1) throw new InvalidInputException("Invalid productId: " + productId);

        if (productId == 13) throw new NotFoundException("No product found for productId: " + productId);


        Product product = restTemplate.getForObject("http://localhost:7001/product/" + productId, Product.class);

        assert product != null;
        int prodID = product.getProductId();


        List<Review> list = new ArrayList<>();
        list.add(new Review(prodID, 1, "Author 1", "Subject 1", "Content 1"));
        list.add(new Review(prodID, 2, "Author 2", "Subject 2", "Content 2"));
        list.add(new Review(prodID, 3, "Author 3", "Subject 3", "Content 3"));

        LOG.debug("/reviews response size: {}", list.size());

        return list;
    }
}
