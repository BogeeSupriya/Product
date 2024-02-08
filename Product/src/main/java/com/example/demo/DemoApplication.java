package com.example.demo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
 // Add the package where DataSeeder is located
@ComponentScan(basePackages = "com.example.demo")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	 // Add the package where DataSeeder is located
	
	  CommandLineRunner dataSeeder(DataSeeder dataSeeder) {
        return args -> {
            // Seed 10,000 records
            dataSeeder.seedData(10000);
        };

    }
}

