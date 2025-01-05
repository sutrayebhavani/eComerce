package com.scalar.ecomerce.service;

import com.scalar.ecomerce.exceptions.ProductNotFoundException;
import com.scalar.ecomerce.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(int id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product addProduct(String name, String description, double price, String imageUrl, String category);
    Product updateProduct(int id, String name, String description, double price, String imageUrl, String category);
    void deleteProduct(int id);
}
