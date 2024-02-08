package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

   
     public void createAndSaveProduct(String name, double price, String description) {
        Product product = new Product();
        String yourGeneratedId = null;
		product.setId(yourGeneratedId); // Set a unique ID
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);

        productRepository.save(product);
    }
    public Product getProduct(String productId) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            throw new Exception("Product not found");
        }
    }

    public Product updateProduct(String productId, Product product) throws Exception {
        Product existingProduct = getProduct(productId);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }

    // Additional methods as needed

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }
    
 // Existing methods...

    public List<ProductReview> getProductReviews(String productId, int page, int size) {
		return null;
        // Implement logic for retrieving product reviews with pagination
        // You may use Spring Data JPA repositories or other methods
        // based on your data access strategy.
    }

    public ProductReview addProductReview(String productId, ProductReview review) throws Exception {
        Product product = getProduct(productId);
        product.addReview(review);
        // Save the product (via repository or other data access method)
		return review;
    }

    public List<Offer> getProductOffers(String productId) {
		return null;
        // Implement logic for retrieving product offers
    }

    public Offer addProductOffer(String productId, Offer offer) throws Exception {
        Product product = getProduct(productId);
        product.addOffer(offer);
        // Save the product (via repository or other data access method)
		return offer;
    }

	public Offer createOffer(String productId, Offer offer) {
		// TODO Auto-generated method stub
		return null;
	}
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return null;
	}
}