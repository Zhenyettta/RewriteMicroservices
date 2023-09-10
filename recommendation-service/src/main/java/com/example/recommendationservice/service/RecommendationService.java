package com.example.recommendationservice.service;



import com.example.recommendationservice.model.Recommendation;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RecommendationService {
    List<Recommendation> getRecommendations(@RequestParam int productId);
}
