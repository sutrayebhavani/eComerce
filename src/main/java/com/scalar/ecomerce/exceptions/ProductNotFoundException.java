package com.scalar.ecomerce.exceptions;

public class ProductNotFoundException extends Exception {
    //creat an obj of ProductNotFoundException cls and set the err msg
    public ProductNotFoundException(String message) {
        super(message);
    }

}
