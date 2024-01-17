package com.example.casemodule4.controller;

import com.example.casemodule4.model.Category;
import com.example.casemodule4.service.ICategoryService;
import com.example.casemodule4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    IProductService productService;

    @Autowired
    ICategoryService categoryService;

    @Value("$={file-upload}")
    private String upload;

    @ModelAttribute("categories")
    public Iterable<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/search")
    public String searchByName(Model model, @RequestParam String keyword, @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("product", productService.searchByName(keyword, pageable));
        return "customer/home";
    }

    @GetMapping("/home")
    public ModelAndView findAll(@PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/customer/home");
        modelAndView.addObject("products", productService.findAll(pageable));
        return modelAndView;
    }

}
