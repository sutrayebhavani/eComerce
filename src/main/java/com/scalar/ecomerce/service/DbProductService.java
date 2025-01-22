package com.scalar.ecomerce.service;

import com.scalar.ecomerce.exceptions.ProductNotFoundException;
import com.scalar.ecomerce.models.Category;
import com.scalar.ecomerce.models.Product;
import com.scalar.ecomerce.repository.CategoryRepository;
import com.scalar.ecomerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dbProductService")
public class DbProductService implements  ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public DbProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(int id) throws ProductNotFoundException {
       Optional<Product> p = productRepository.findById(id);
       if(p.isPresent()){
           return  p.get();
       }
       else{
           throw new ProductNotFoundException("product not found");
       }
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(String name, String description, double price, String imageUrl, String category) {
        Category currentCat = categoryRepository.findByName(category);
        Product p = new Product();
        if(currentCat==null){
            Category c = new Category();
            c.setName(category);
            categoryRepository.save(c);
            p.setCategory(c);
        }
        else{
            p.setCategory(currentCat);
        }
        p.setName(name);
        p.setDescription(description);
        p.setPrice(price);
        p.setImageUrl(imageUrl);
        productRepository.save(p);
        return p;
    }

    @Override
    public Product updateProduct(int id, String name, String description, double price, String imageUrl, String category) {
        Product p = productRepository.findById(id).get();
        p.setPrice(price);
        productRepository.save(p);
        return p;
    }

    @Override
    public void deleteProduct(int id) {
        Product p = productRepository.findById(id).get();
        productRepository.delete(p);
    }
}
