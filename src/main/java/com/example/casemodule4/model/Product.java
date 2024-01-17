package com.example.casemodule4.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private Long price;
    private Long quantity;

    @Transient
    private MultipartFile file;

    @ManyToOne
    private Category category;

}
