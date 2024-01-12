package com.example.casemodule4.controller;

import com.example.casemodule4.model.Category;
import com.example.casemodule4.model.Product;
import com.example.casemodule4.service.ICategoryService;
import com.example.casemodule4.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("admin/products")
public class AdminController {
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


    @GetMapping("")
    public ModelAndView findAll(@PageableDefault(size = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", productService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("/product/form");
        modelAndView.addObject("products", new Product());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showUpdateForm(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("/product/form");
        modelAndView.addObject("products", productService.findById(id));
        return modelAndView;
    }

    @PostMapping
    public String save(@ModelAttribute Product product) {
        MultipartFile file = product.getFile();
        if (file.getSize() != 0) {
            String fileName = file.getOriginalFilename();
            try {
                FileCopyUtils.copy(file.getBytes(), new File(upload + fileName));
                product.setImage(fileName);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (product.getId() == null) {
            product.setImage("No image.jpg");
        } else {
            product.setImage(productService.findById(product.getId()).getImage());
        }
        System.out.println(file.getOriginalFilename());
        productService.save(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.remove(id);
        return "redirect:/admin/products";
    }
}
