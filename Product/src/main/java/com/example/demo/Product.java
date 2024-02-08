package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;

@Entity
public class Product {

    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id; // Change the type from Long to String

    private String name;
    private double price;
    private String description; 

    // Constructors, getters, setters, and other methods

    public Product() {
        // Default constructor
    }

    public Product(String id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.setDescription(description);
    }

    
	// Getters and setters

	public String getId() { // Change the return type from Long to String
		return id;
	}

	public void setId(String id) { // Change the parameter type from Long to String
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
        return "Product{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", price=" + price + ", description='" + description + '\'' + '}';
    }

	public void addReview(ProductReview review) {
		// TODO Auto-generated method stub

	}

	public void addOffer(Offer offer) {
		// TODO Auto-generated method stub

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
