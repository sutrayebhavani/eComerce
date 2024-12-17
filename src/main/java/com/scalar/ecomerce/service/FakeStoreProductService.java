package com.scalar.ecomerce.service;

import com.scalar.ecomerce.dto.FakeStoreProductDTO;
import com.scalar.ecomerce.exceptions.ProductNotFoundException;
import com.scalar.ecomerce.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product getProductById(int id) throws ProductNotFoundException {
       FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDTO.class);
       if(fakeStoreProductDTO==null){
           throw new ProductNotFoundException("Product not found with id "+id);
       }
       return fakeStoreProductDTO.getProduct();
    }

    public List<Product> getAllProducts() {
       FakeStoreProductDTO[] fakeStoreProductDTO = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);
        Product[] products = new Product[fakeStoreProductDTO.length];
        for (int i=0;i<fakeStoreProductDTO.length;i++) {
            products[i]=(fakeStoreProductDTO[i].getProduct());
        }
        return List.of(products);

    }

    public Product addProduct(int id, String name, String description, double price, String imageUrl, String category) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(id);
        fakeStoreProductDTO.setTitle(name);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setImage(imageUrl);
        fakeStoreProductDTO.setCategory(category);
       FakeStoreProductDTO response = restTemplate.postForObject("https://fakestoreapi.com/products",fakeStoreProductDTO,FakeStoreProductDTO.class);
        return response.getProduct();
    }
    public Product updateProduct(int id, String name, String description, double price, String imageUrl, String category) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(id);
        fakeStoreProductDTO.setTitle(name);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setCategory(category);
        restTemplate.put("https://fakestoreapi.com/products/"+id, fakeStoreProductDTO);
        return fakeStoreProductDTO.getProduct();
    }
    public void deleteProduct(int id) {
        restTemplate.delete("https://fakestoreapi.com/products/"+id);

    }
}
