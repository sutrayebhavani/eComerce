package com.scalar.ecomerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Product extends BaseModel {
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    @ManyToOne
    private Category  category;

    public Product() {

    }
    public Product(Category category, String imageUrl, double price, String description, String name, int id) {
        this.category = category;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
