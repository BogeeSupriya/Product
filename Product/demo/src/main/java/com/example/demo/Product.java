package com.example.demo;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
	public class Product {
	    @Id
	   // @GeneratedValue(strategy = GenerationType.IDENTITY)
	   
	    private Long id;
        private String name;
	    private double price;

	 // Constructors (default and parameterized)

	    public Product() {
	        // Default constructor
	    }

	    public Product(String name, double price) {
	        this.name = name;
	        this.price = price;
	    }

	    // Getters and setters

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }

	    // toString method for better logging and debugging

	    @Override
	    public String toString() {
	        return "Product{" +"id=" + id +
	                ", name='" + name + '\'' +
	                ", price=" + price + '}';
	    }

}

