package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javassist.NotFoundException;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Test
    void createProduct_Success() throws Exception {
        // Arrange
        Product mockProduct = new Product("1", "Test Product", 19.99, "Product description");
        when(productService.save(any())).thenReturn(mockProduct);

        // Act
        ResponseEntity<Product> response = productController.createProduct(mockProduct);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockProduct, response.getBody());
    }

    @Test
    void createProduct_Failure() throws Exception {
        // Arrange
        when(productService.save(any())).thenReturn(null);

        // Act
        ResponseEntity<Product> response = productController.createProduct(new Product());

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void getProduct_Success() throws Exception {
        // Arrange
        Product mockProduct = new Product("1", "Test Product", 19.99, "Product description");
        when(productService.getProduct(any())).thenReturn(mockProduct);

        // Act
        ResponseEntity<Product> response = productController.getProduct("1");

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockProduct, response.getBody());
    }

    @Test
    void getProduct_NotFound() throws Exception {
        // Arrange
        when(productService.getProduct(any())).thenThrow(new Exception("Product not found"));

        // Act
        ResponseEntity<Product> response = productController.getProduct("1");

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNull(response.getBody());
    }
    
    
    @Test
    void updateProduct_Success() throws Exception {
        // Arrange
        Product mockProduct = new Product("1", "Test Product", 19.99, "Product description");
        when(productService.updateProduct(any(), any())).thenReturn(mockProduct);

        // Act
        ResponseEntity<Product> response = productController.updateProduct("1", new Product());

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockProduct, response.getBody());
    }

    @Test
    void updateProduct_NotFound() throws Exception {
        // Arrange
        when(productService.updateProduct(any(), any())).thenThrow(new Exception("Product not found"));

        // Act
        ResponseEntity<Product> response = productController.updateProduct("1", new Product());

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNull(response.getBody());
    }

    

    @Test
    void addProductReview_Success() throws Exception {
        // Arrange
        ProductReview mockReview = new ProductReview(new Product(), "Excellent!", 5);
        when(productService.addProductReview(any(), any())).thenReturn(mockReview);

        // Act
        ResponseEntity<ProductReview> response = productController.addProductReview("1", new ProductReview());

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockReview, response.getBody());
    }

    @Test
    void addProductReview_NotFound() throws Exception {
        // Arrange
        doThrow(new NotFoundException("Product not found")).when(productService).addProductReview(any(), any());

        // Act
        ResponseEntity<ProductReview> response = productController.addProductReview("1", new ProductReview());

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    

    @Test
    void addProductOffer_Success() throws Exception {
        // Arrange
        Offer mockOffer = new Offer("1", "Discount", 0.1);
        when(productService.addProductOffer(any(), any())).thenReturn(mockOffer);

        // Act
        ResponseEntity<Offer> response = productController.addProductOffer("1", new Offer());

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockOffer, response.getBody());
    }

    @Test
    void addProductOffer_NotFound() throws Exception {
        // Arrange
        doThrow(new NotFoundException("Product not found")).when(productService).addProductOffer(any(), any());

        // Act
        ResponseEntity<Offer> response = productController.addProductOffer("1", new Offer());

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }
    
   
}
