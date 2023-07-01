package com.mackittipat.macbootmongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "reviews")
public class Review {

    @Id
    private String id;
    private String comment;
    private String reviewer;
    private LocalDateTime createdTime = LocalDateTime.now();

    public Review(String comment, String reviewer) {
        this.comment = comment;
        this.reviewer = reviewer;
    }
}
