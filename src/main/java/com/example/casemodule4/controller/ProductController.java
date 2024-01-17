package com.example.casemodule4.controller;

import com.example.casemodule4.model.Product;
import com.example.casemodule4.service.IProductService;
import com.example.casemodule4.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/search")
    public List<Product> searchProducts(@RequestParam("keyword") String keyword) {
        return productService.searchProducts(keyword);
    }
//    @Autowired
//    IProductService productService;
//
//    @GetMapping("")
//    public ModelAndView findAll(@PageableDefault Pageable pageable) {
//        ModelAndView modelAndView = new ModelAndView("/product/list");
//        modelAndView.addObject("products", productService.findAll(pageable));
//        return modelAndView;
//    }
}
