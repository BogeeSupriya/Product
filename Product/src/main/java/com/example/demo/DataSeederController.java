package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/data-seeder")
public class DataSeederController {

    @Autowired
    private DataSeeder dataSeeder;

    @PostMapping("/seed")
    public void seedData(@RequestParam int numberOfRecords) {
        dataSeeder.seedData(numberOfRecords);
    }
}

