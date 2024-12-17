package com.scalar.ecomerce.controller;

import com.scalar.ecomerce.models.Product;
import com.scalar.ecomerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    //crud on product
    //@RequestMapping(value = "/hello",method = RequestMethod.GET)
    @Autowired
    private  ProductService ProductService;
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
      Product result = ProductService.addProduct(product.getId(),product.getName(),product.getDescription(),product.getPrice(),product.getImageUrl(),product.getCategory().getName());
      return result;
    }
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return ProductService.getProductById(id);
    }
    @GetMapping("/products")
    public List<Product> getAllProducts() {
       return ProductService.getAllProducts();

    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") int id,@RequestBody Product product) {
        return ProductService.updateProduct(id,product.getName(),product.getDescription(),product.getPrice(),product.getImageUrl(),product.getCategory().getName());
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        ProductService.deleteProduct(id);
        return "Product deleted successfully";
    }
}
