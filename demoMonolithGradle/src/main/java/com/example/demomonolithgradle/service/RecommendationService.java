package com.example.demomonolithgradle.service;


import com.example.demomonolithgradle.model.Recommendation;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RecommendationService {
    List<Recommendation> getRecommendations(@RequestParam int productId);
}
