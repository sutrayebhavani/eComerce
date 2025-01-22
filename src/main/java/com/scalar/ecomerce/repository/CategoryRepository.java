package com.scalar.ecomerce.repository;

import com.scalar.ecomerce.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findById(int id);
    Category findByName(String name);


}
