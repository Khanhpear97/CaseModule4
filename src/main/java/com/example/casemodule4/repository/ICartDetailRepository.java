package com.example.casemodule4.repository;

import com.example.casemodule4.model.Cart;
import com.example.casemodule4.model.CartDetail;
import com.example.casemodule4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICartDetailRepository extends JpaRepository<CartDetail, Long> {
    Optional<CartDetail> findByProductAndCart(Product product, Cart cart);

    Iterable<CartDetail> findAllByCartStatus(Boolean status);
}
