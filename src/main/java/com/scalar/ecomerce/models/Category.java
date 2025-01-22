package com.scalar.ecomerce.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category extends BaseModel {
    private int id;
    private String name;

    public Category() {

    }
    public Category(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
