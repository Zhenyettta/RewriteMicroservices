package com.example.demomonolithgradle.service;


import com.example.demomonolithgradle.model.Review;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ReviewService {
    List<Review> getReviews(@RequestParam(value = "productId", required = true) int productId);
}
