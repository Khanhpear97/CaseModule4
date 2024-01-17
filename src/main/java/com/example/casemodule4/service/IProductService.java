package com.example.casemodule4.service;

import com.example.casemodule4.model.Category;
import com.example.casemodule4.model.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService extends IGenerateService<Product> {
    List<Product> searchByName(String keyword, Pageable pageable);
}
