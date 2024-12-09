package controller;

import models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    //crud on product
    //@RequestMapping(value = "/products",method = RequestMethod.POST)
    @PostMapping("/products")
    public void createProduct(Product product) {

    }
    public Product getProduct(int id) {
        return null;
    }
    public void updateProduct(Product product) {

    }
    public void deleteProduct(int id) {

    }
}
