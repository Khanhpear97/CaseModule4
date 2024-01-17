package com.example.casemodule4.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "table")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private Long price;
    private Long quantity;

    @ManyToOne
    private Category category;

    public Product (Long id, String name, String image, Long price, Long quantity, Category category) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Product ( ) {

    }

    public Long getId ( ) {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName ( ) {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getImage ( ) {
        return image;
    }

    public void setImage (String image) {
        this.image = image;
    }

    public Long getPrice ( ) {
        return price;
    }

    public void setPrice (Long price) {
        this.price = price;
    }

    public Long getQuantity ( ) {
        return quantity;
    }

    public void setQuantity (Long quantity) {
        this.quantity = quantity;
    }

    public Category getCategory ( ) {
        return category;
    }

    public void setCategory (Category category) {
        this.category = category;
    }
}
