package com.example.casemodule4.controller;

import com.example.casemodule4.model.Product;
import com.example.casemodule4.model.SearchOBJ;
import com.example.casemodule4.repository.IProductRepository;
import com.example.casemodule4.service.IProductService;
import com.example.casemodule4.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductRepository productRepository;

}
