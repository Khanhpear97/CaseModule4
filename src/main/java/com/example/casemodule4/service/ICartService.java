package com.example.casemodule4.service;

import com.example.casemodule4.model.Cart;
import com.example.casemodule4.model.CartDetail;
import com.example.casemodule4.model.Product;

public interface ICartService {
    Iterable<CartDetail> findAllByStatus();
    Cart findByStatus();

    void addToCart(Product product);

    void up(Long id);

    void down(Long id);

    void delete(Long id);

    void deleteAll();

    void payment(Long cId);
}
