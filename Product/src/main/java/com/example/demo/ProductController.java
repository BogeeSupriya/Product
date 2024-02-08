package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

   
    @PostMapping
    
    public ResponseEntity<Product> createProduct(@Validated @RequestBody Product product) {
        try {
            // Business logic for creating a product
            Product createdProduct = productService.save(product);

            // Check if the product creation was successful
            if (createdProduct != null) {
                // Return a 201 Created response with the created product
                return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
            } else {
                // Handle a case where the product creation failed
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
        } catch (Exception e) {
            // Handle unexpected exceptions, log the error for debugging
            e.printStackTrace();

            // Return a 500 Internal Server Error response for unexpected errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable String productId) throws Exception {
        Product product = productService.getProduct(productId);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable String productId, @RequestBody Product product) throws Exception {
        Product updatedProduct = productService.updateProduct(productId, product);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{productId}")
	public ResponseEntity<DeleteResponse> deleteProduct(@PathVariable String productId) throws NotFoundException {
		try {
			productService.deleteProduct(productId);
			return ResponseEntity.ok(new DeleteResponse("Product deleted successfully"));
		} catch (Exception e) {
			// Handle other unexpected exceptions, log the error for debugging
			e.printStackTrace();

			// Return a 500 Internal Server Error response for unexpected errors
			String errorCode = "errInternalError";
			@SuppressWarnings("unused")
			String errorMessage = "Internal server error occurred";
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new DeleteResponse(errorCode));
		}
	}
    
    @GetMapping("/{productId}/reviews")
    public ResponseEntity<List<ProductReview>> getProductReviews(@PathVariable String productId,
                                                                @RequestParam(defaultValue = "0") int page,
                                                                @RequestParam(defaultValue = "10") int size) {
        List<ProductReview> reviews = productService.getProductReviews(productId, page, size);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping("/{productId}/reviews")
	public ResponseEntity<ProductReview> addProductReview(@PathVariable String productId,
			@Validated @RequestBody ProductReview review) {

		try {
			ProductReview createdReview = productService.addProductReview(productId, review);

			if (createdReview != null) {
				return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
			} else {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

    @GetMapping("/{productId}/offers")
    public ResponseEntity<List<Offer>> getProductOffers(@PathVariable String productId) {
        List<Offer> offers = productService.getProductOffers(productId);
        return ResponseEntity.ok(offers);
    }

   
     @PostMapping("/{productId}/offers")
    public ResponseEntity<Offer> addProductOffer(@PathVariable String productId, @RequestBody Offer offer) throws Exception {
        Offer appliedOffer = productService.addProductOffer(productId, offer);
        
        if (appliedOffer != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(appliedOffer);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

   

}