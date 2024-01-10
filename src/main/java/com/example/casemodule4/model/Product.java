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
}
