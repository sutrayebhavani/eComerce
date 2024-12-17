package com.scalar.ecomerce.dto;

import com.scalar.ecomerce.models.Category;
import com.scalar.ecomerce.models.Product;

public class FakeStoreProductDTO {
    private int id;
    private String title;
    private String description;
    private double price;
    private String category;
    public String image;

    //this will get the product of my implementation using the vals from fake store
   public Product getProduct() {
        Product product = new Product();
        product.setId(id);
        product.setName(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);

        Category category = new Category();
        category.setName(this.category);
        product.setCategory(category);
        return product;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
