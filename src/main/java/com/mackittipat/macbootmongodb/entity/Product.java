package com.mackittipat.macbootmongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private Double price;
    @Field(value = "reviews")
    private List<Review> reviewList;

    public Product(String name, Double price, List<Review> reviewList) {
        this.name = name;
        this.price = price;
        this.reviewList = reviewList;
    }
}
