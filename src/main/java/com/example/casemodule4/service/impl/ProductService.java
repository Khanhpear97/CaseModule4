package com.example.casemodule4.service.impl;

import com.example.casemodule4.model.Product;
import com.example.casemodule4.model.SearchOBJ;
import com.example.casemodule4.repository.IProductRepository;
import com.example.casemodule4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Page<Product> findAll (Pageable pageable) {
        return null;
    }

    @Override
    public void save(Product product) {

        productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.delete(productRepository.findById(id).get());
    }

    @Override
    public void reduceQuantity(Long id, int quantity) {
        Product product = productRepository.findById(id).get();
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
    }

    @Override
    public void reducePrice(Long id, double price) {
        Product product = productRepository.findById(id).get();
        product.setPrice((long) (product.getPrice() - price));
        productRepository.save(product);
    }

    @Override
    public Iterable<Product> searchByGender(String gender) {
        Iterable<Product> productIterable = productRepository.searchByGender(gender);
        return productIterable;
    }

    @Override
    public Iterable<Product> searchProductByName(String name) {
        String newString = "%" + name + "%";
        return productRepository.search3(newString);
    }

    @Override
    public Iterable<Product> filter(SearchOBJ searchOBJ) {

        Long num1 = searchOBJ.getNum1();
        Long num2 = searchOBJ.getNum2();
        Long id = searchOBJ.getId();
        String name = searchOBJ.getName();
        String searchName = "%" + searchOBJ.getName() + "%";

        if (num1 != null && num2 != null && id != null & name != null) {
            return productRepository.search1and2and3(num1, num2, id, searchName);
        } else if (num1 != null && num2 != null && id != null & name == null) {
            return productRepository.search1and2(num1, num2, id);
        } else if (num1 != null && num2 != null && id == null & name != null) {
            return productRepository.search1and3(num1, num2, searchName);
        } else if (num1 != null && num2 != null && id == null & name == null) {
            return productRepository.Search1(num1, num2);
        } else if (num1 == null && num2 == null && id != null & name == null) {
            return productRepository.search2(id);
        } else if (num1 == null && num2 == null && id != null & name != null) {
            return productRepository.search2and3(id, searchName);
        } else {
            return productRepository.search3(searchName);
        }
    }
}
