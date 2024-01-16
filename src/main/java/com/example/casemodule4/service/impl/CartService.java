package com.example.casemodule4.service.impl;

import com.example.casemodule4.model.Cart;
import com.example.casemodule4.model.CartDetail;
import com.example.casemodule4.model.Product;
import com.example.casemodule4.repository.ICartDetailRepository;
import com.example.casemodule4.repository.ICartRepository;
import com.example.casemodule4.service.ICartService;
import com.example.casemodule4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {

    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private ICartDetailRepository cartDetailRepository;

    @Autowired
    private IProductService productService;

    @Override
    public Iterable<CartDetail> findAllByStatus() {
        return cartDetailRepository.findAllByCartStatus(false);
    }

    @Override
    public Cart findByStatus() {
        return cartRepository.findByStatus(false).orElse(null);
    }

    @Override
    public void addToCart(Product product) {
        Cart cart = findByStatus();
        CartDetail cartDetail;
        if (cart == null) {
            Cart newCart = new Cart();
            newCart.setStatus(false);
            cartDetail = new CartDetail();
            cartDetail.setQuantity(1L);
            cartDetail.setProduct(product);
            cartDetail.setCart(newCart);
            cartRepository.save(newCart);
        } else {
            Optional<CartDetail> cartDetailOptional = cartDetailRepository.findByProductAndCart(product, cart);
            if (cartDetailOptional.isPresent()) {
                cartDetail = cartDetailOptional.get();
                cartDetail.setQuantity(cartDetailOptional.get().getQuantity() + 1);
            } else {
                cartDetail = new CartDetail();
                cartDetail.setQuantity(1L);
                cartDetail.setProduct(product);
                cartDetail.setCart(cart);
                cartRepository.save(cart);
            }
        }
        cartDetailRepository.save(cartDetail);
        product.setQuantity(product.getQuantity() - 1);
        productService.save(product);
    }

    @Override
    public void up(Long id) {
        CartDetail cartDetail = cartDetailRepository.findById(id).get();
        if (cartDetail.getProduct().getQuantity() > 1) {
            cartDetail.setQuantity(cartDetail.getQuantity() + 1);
            cartDetailRepository.save(cartDetail);
            cartDetail.getProduct().setQuantity(cartDetail.getProduct().getQuantity() - 1);
            productService.save(cartDetail.getProduct());
        }
    }

    @Override
    public void down(Long id) {
        CartDetail cartDetail = cartDetailRepository.findById(id).get();
        if (cartDetail.getQuantity() > 1) {
            cartDetail.setQuantity(cartDetail.getQuantity() - 1);
            cartDetailRepository.save(cartDetail);
            cartDetail.getProduct().setQuantity(cartDetail.getProduct().getQuantity() + 1);
            productService.save(cartDetail.getProduct());
        }
    }

    @Override
    public void delete(Long id) {
        CartDetail cartDetail = cartDetailRepository.findById(id).get();
        cartDetail.getProduct().setQuantity(cartDetail.getProduct().getQuantity() + cartDetail.getQuantity());
        productService.save(cartDetail.getProduct());
        cartDetailRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        List<CartDetail> cartDetails = (List<CartDetail>) findAllByStatus();
        for (CartDetail c : cartDetails) {
            Product product = c.getProduct();
            product.setQuantity(product.getQuantity() + c.getQuantity());
            productService.save(product);
        }
        cartDetailRepository.deleteAll(cartDetails);
    }

    @Override
    public void payment(Long cId) {
        Optional<Cart> cartOptional = cartRepository.findById(cId);
        List<CartDetail> cartDetails = (List<CartDetail>) findAllByStatus();
        long total = 0L;
        for (CartDetail c : cartDetails) {
            total += c.getQuantity() * c.getProduct().getPrice();
        }
        cartOptional.get().setTotal(total);
        cartOptional.get().setStatus(true);
        cartRepository.save(cartOptional.get());
    }
}
