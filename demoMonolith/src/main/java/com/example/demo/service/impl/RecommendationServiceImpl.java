package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.model.Recommendation;
import com.example.demo.service.ProductService;
import com.example.demo.service.RecommendationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    private final ProductService productService;
    private static final Logger LOG = LoggerFactory.getLogger(RecommendationServiceImpl.class);

    public RecommendationServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<Recommendation> getRecommendations(int productId) {
        Product product = productService.getProduct(productId);
        int prodId = product.getProductId();

        List<Recommendation> list = new ArrayList<>();
        list.add(new Recommendation(prodId, 1, "Author 1", 1, "Content 1"));
        list.add(new Recommendation(prodId, 2, "Author 2", 2, "Content 2"));
        list.add(new Recommendation(prodId, 3, "Author 3", 3, "Content 3"));

        LOG.debug("/recommendation response size: {}", list.size());

        return list;
    }
}
