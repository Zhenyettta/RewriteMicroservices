package com.example.recommendationservice.controller;



import com.example.recommendationservice.model.Recommendation;
import com.example.recommendationservice.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendation")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @Autowired
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping(value = "/{productId}")
    public ResponseEntity<List<Recommendation>> getRecommendations(@PathVariable int productId) {
        List<Recommendation> recommendations = recommendationService.getRecommendations(productId);
        return new ResponseEntity<>(recommendations, HttpStatus.OK);
    }
}
