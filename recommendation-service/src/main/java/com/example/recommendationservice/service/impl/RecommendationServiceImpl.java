package com.example.recommendationservice.service.impl;


import com.example.recommendationservice.exceptions.InvalidInputException;
import com.example.recommendationservice.exceptions.NotFoundException;
import com.example.recommendationservice.model.Product;
import com.example.recommendationservice.model.Recommendation;
import com.example.recommendationservice.service.RecommendationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {

    private static final Logger LOG = LoggerFactory.getLogger(RecommendationServiceImpl.class);
    private final RestTemplate restTemplate;

    @Autowired
    public RecommendationServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public List<Recommendation> getRecommendations(int productId) {
        if (productId < 1) throw new InvalidInputException("Invalid productId: " + productId);

        if (productId == 13) throw new NotFoundException("No product found for productId: " + productId);


        Product product = restTemplate.getForObject("Http://localhost:7001/product/" + productId, Product.class);

        assert product != null;
        int prodID = product.getProductId();


        List<Recommendation> list = new ArrayList<>();
        list.add(new Recommendation(prodID, 1, "Author 1", 1, "Content 1"));
        list.add(new Recommendation(prodID, 2, "Author 2", 2, "Content 2"));
        list.add(new Recommendation(prodID, 3, "Author 3", 3, "Content 3"));

        LOG.debug("/recommendation response size: {}", list.size());

        return list;
    }
}
