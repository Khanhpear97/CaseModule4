package com.example.casemodule4.controller;

import com.example.casemodule4.service.ICartService;
import com.example.casemodule4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private IProductService productService;

    @Autowired
    private ICartService cartService;


}
