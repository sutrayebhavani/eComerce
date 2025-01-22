package com.scalar.ecomerce.repository;

import com.scalar.ecomerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findById(int id); //this will find a product by its id
    Product findByDescription(String description);
    Product save(Product product); //this will save or create a new product in the table
    void deleteById(int id); //this will delete a product by its id
}
