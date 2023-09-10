package com.example.demomonolithgraddle.service;

import com.example.demomonolithgraddle.model.Recommendation;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RecommendationService {
    List<Recommendation> getRecommendations(@RequestParam int productId);
}
