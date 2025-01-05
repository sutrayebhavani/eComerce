package com.scalar.ecomerce.controller;

import com.scalar.ecomerce.dto.ErrorDTO;
import com.scalar.ecomerce.exceptions.ProductNotFoundException;
import com.scalar.ecomerce.models.Product;
import com.scalar.ecomerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private  ProductService productService;
    public ProductController(@Qualifier("dbProductService") ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
      Product result = productService.addProduct(product.getName(),product.getDescription(),product.getPrice(),product.getImageUrl(),product.getCategory().getName());
      return result;
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int id) throws ProductNotFoundException {
        Product product = productService.getProductById(id);
        if(product==null){
            throw new ProductNotFoundException("Product not found");
        }
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        return responseEntity;
    }
    @GetMapping("/products")
    public List<Product> getAllProducts() {
       return productService.getAllProducts();

    }
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") int id,@RequestBody Product product) {
        return productService.updateProduct(id,product.getName(),product.getDescription(),product.getPrice(),product.getImageUrl(),product.getCategory().getName());
    }

    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }

    @ExceptionHandler(ProductNotFoundException.class) //handleException method is called when any api method throws ProductNotFoundException
    public ResponseEntity<ErrorDTO> handleException(Exception ex){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setMessage(ex.getMessage());
        ResponseEntity<ErrorDTO> responseEntity = new ResponseEntity<>(errorDTO,HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
