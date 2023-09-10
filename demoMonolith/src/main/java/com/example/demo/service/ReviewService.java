package com.example.demo.service;

import com.example.demo.model.Review;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ReviewService {
    List<Review> getReviews(@RequestParam(value = "productId", required = true) int productId);
}
