package com.example.demomonolithgraddle.service.impl;

import com.example.demomonolithgraddle.exceptions.InvalidInputException;
import com.example.demomonolithgraddle.exceptions.NotFoundException;
import com.example.demomonolithgraddle.model.Product;
import com.example.demomonolithgraddle.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public Product getProduct(int productId) {
        LOG.debug("/product return the found product for productId={}", productId);

        if (productId < 1) {
            throw new InvalidInputException("Invalid productId: " + productId);
        }

        if (productId == 13) {
            throw new NotFoundException("No product found for productId: " + productId);
        }

        return new Product(productId, "name-" + productId, 123);
    }

}
