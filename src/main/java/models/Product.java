package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private String image;
    private Category category;

    public  Product() {

    }
    public Product(Category category, String image, double price, String description, String name, int id) {
        this.category = category;
        this.image = image;
        this.price = price;
        this.description = description;
        this.name = name;
        this.id = id;
    }
}
