package com.mackittipat.macbootmongodb.repos;

import com.mackittipat.macbootmongodb.entity.Product;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepo extends PagingAndSortingRepository<Product, String> {

    // Search product by reviewer and exclude reviews field
    @Query(value = "{ 'reviews.reviewer' : '?0' }", fields = "{ 'reviews' : 0 }")
    List<Product> findProductByReviewer(String reviewer);

}
