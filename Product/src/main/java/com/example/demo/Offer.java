package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Offer {
	@Id
	private String id;

	private String productId;
	private String offerDescription;
	private double discount;

	// Constructors (default and parameterized)

	public Offer() {
		// Default constructor
	}

	public Offer(String productId, String offerDescription, double discount) {
		this.productId = productId;
		this.offerDescription = offerDescription;
		this.discount = discount;
	}

	// Getters and setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getOfferDescription() {
		return offerDescription;
	}

	public void setOfferDescription(String offerDescription) {
		this.offerDescription = offerDescription;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	// toString method for better logging and debugging

	@Override
	public String toString() {
		return "Offer{" + "id='" + id + '\'' + ", productId='" + productId + '\'' + ", offerDescription='"
				+ offerDescription + '\'' + ", discount=" + discount + '}';
	}
}
