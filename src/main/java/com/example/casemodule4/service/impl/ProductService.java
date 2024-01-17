package com.example.casemodule4.service.impl;

import com.example.casemodule4.model.Product;
import com.example.casemodule4.model.SearchOBJ;
import com.example.casemodule4.repository.IProductRepository;
import com.example.casemodule4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;


@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<Product> findAll ( ) {
        return null;
    }

    @Override
    public void reduceQuantity (Long id, int quantity) {

    }

    @Override
    public void reducePrice (Long id, double price) {

    }

    @Override
    public Iterable<Product> searchByGender (String gender) {
        return null;
    }

    @Override
    public Iterable<Product> searchProductByName (String name) {
        return null;
    }

    @Override
    public Iterable<Product> filter (SearchOBJ searchOBJ) {
        return null;
    }
}
