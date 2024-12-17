package com.scalar.ecomerce.service;

import com.scalar.ecomerce.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(int id);
    List<Product> getAllProducts();
    Product addProduct(int id, String name, String description, double price, String imageUrl, String category);
    Product updateProduct(int id, String name, String description, double price, String imageUrl, String category);
    void deleteProduct(int id);
}
