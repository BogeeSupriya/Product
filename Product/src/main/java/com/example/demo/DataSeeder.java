package com.example.demo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class DataSeeder {

	@Autowired
	private ProductService productService;

	public void seedData(int numberOfRecords) {
		for (int i = 0; i < 10000; i++) {
			Product product = generateRandomProduct();
			productService.save(product);

			// Log or print progress if necessary
			System.out.println("Seeded record: " + i);
		}
	}

	private Product generateRandomProduct() {
		Random random = new Random();
		String randomName = "Product " + (random.nextInt(100) + 1);
		double randomPrice = 10 + (100 - 10) * random.nextDouble();
		String randomDescription = "Description for " + randomName;

		return new Product(null, randomName, randomPrice, randomDescription);
	}

}
