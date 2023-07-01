package com.mackittipat.macbootmongodb;

import com.mackittipat.macbootmongodb.entity.Product;
import com.mackittipat.macbootmongodb.entity.Review;
import com.mackittipat.macbootmongodb.repos.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootApplication
public class MacBootMongodbApplication implements CommandLineRunner {

    @Autowired
    private ProductRepo productRepo;

    public static void main(String[] args) {
        SpringApplication.run(MacBootMongodbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Removing existing data");
        productRepo.deleteAll();

        Product pOppoPhone = new Product("OppoPhone", 29999D, Arrays.asList(
                new Review("This is great product", "Mac"),
                new Review("I love it", "Bbb")));
        pOppoPhone = productRepo.save(pOppoPhone);
        log.info("Save product = {}", pOppoPhone.toString());

		Product pMacBook = new Product("MacBook", 75000D, Arrays.asList(
				new Review("I am a fan of this product", "Aaa"),
				new Review("Thumbs up", "Ccc"),
				new Review("Great product", "Ddd")));
		pMacBook = productRepo.save(pMacBook);
		log.info("Save product = {}", pMacBook.toString());

		Product pLogitecKeyboard = new Product("LogitecKeyboard", 999.99, Arrays.asList(
				new Review("Smooth Keyboard", "Aaa"),
				new Review("Thumbs up again", "Ccc"),
				new Review("Love it", "Bbb")));
		pLogitecKeyboard = productRepo.save(pLogitecKeyboard);
		log.info("Save product = {}", pLogitecKeyboard.toString());

		List<Product> productList = productRepo.findProductByReviewer("Aaa");
		log.info("Found product with reviewer AAA. {}}", productList.toString());
    }
}
