package com.example.demo.service;

import com.example.demo.model.Recommendation;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RecommendationService {
    List<Recommendation> getRecommendations(@RequestParam int productId);
}
