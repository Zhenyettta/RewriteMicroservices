package com.example.recommendationservice.model;

public class Product {
    private final int productId;
    private final String name;
    private final int weight;


    public Product() {
        productId = 0;
        name = null;
        weight = 0;

    }

    public Product(int productId, String name, int weight) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

}
