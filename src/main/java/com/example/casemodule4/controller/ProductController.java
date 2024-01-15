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


    @GetMapping("")
    public ResponseEntity<Iterable<Product>> showAll() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> findOne(@PathVariable("id") Long id) {
        Optional<Product> product = Optional.ofNullable(productService.findById(id));
        if (product.isPresent()) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") Long id) {
        Optional<Product> product1 = Optional.ofNullable(productService.findById(id));
        product.setId(product1.get().getId());
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        productService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/men")
    public ResponseEntity<Iterable<Product>> searchMen() {
        Iterable<Product> products = productService.searchByGender("Nam");
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/women")
    public ResponseEntity<Iterable<Product>> searchWomen() {
        return new ResponseEntity<>(productService.searchByGender("Nữ"), HttpStatus.OK);
    }

    @PostMapping("/productRepository")
    public ResponseEntity<Iterable<Product>> searchProductByName(@RequestBody Product product) {
        return new ResponseEntity<>(productService.searchProductByName(product.getName()), HttpStatus.OK);
    }

    @PostMapping("/filter")
    public ResponseEntity<Iterable<Product>> filter(@RequestBody SearchOBJ searchOBJ) {
        Iterable<Product> products = productService.filter(searchOBJ);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
//    @PostMapping("/search")
//    public ResponseEntity<Iterable<Product>> searchAll(@RequestBody SearchOBJ searchOBJ) {
//
//        Double num1 = searchOBJ.getNum1();
//        Double num2 = searchOBJ.getNum2();
//        Long id = searchOBJ.getId();
//        String name = "%"+searchOBJ.getName()+"%";
////        Iterable<Product> products =productRepository.search1and2();
//        Iterable<Product> products =productRepository.search1and3(num1,num2,name);
////        Iterable<Product> products =productRepository.search1and2and3(num1,num2,id,name);
////        Iterable<Product> products =productRepository.search2and3(id,name);
////        Iterable<Product> products =productRepository.search3(name);
//
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
}
