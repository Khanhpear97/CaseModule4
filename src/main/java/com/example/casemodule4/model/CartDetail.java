package com.example.casemodule4.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cart-detail")
@Data
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Cart cart;
    private Long quantity;
}
