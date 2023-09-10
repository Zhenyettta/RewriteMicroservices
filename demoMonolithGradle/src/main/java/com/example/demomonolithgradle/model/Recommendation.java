package com.example.demomonolithgradle.model;

public class Recommendation {
    private final int productId;
    private final int recommendationId;
    private final String author;
    private final int rate;
    private final String content;

    public Recommendation() {
        productId = 0;
        recommendationId = 0;
        author = null;
        rate = 0;
        content = null;
    }

    public Recommendation(
            int productId,
            int recommendationId,
            String author,
            int rate,
            String content) {

        this.productId = productId;
        this.recommendationId = recommendationId;
        this.author = author;
        this.rate = rate;
        this.content = content;
    }

    public int getProductId() {
        return productId;
    }

    public int getRecommendationId() {
        return recommendationId;
    }

    public String getAuthor() {
        return author;
    }

    public int getRate() {
        return rate;
    }

    public String getContent() {
        return content;
    }

}
