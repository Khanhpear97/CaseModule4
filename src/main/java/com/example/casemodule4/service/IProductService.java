package com.example.casemodule4.service;

import com.example.casemodule4.model.Product;
import com.example.casemodule4.model.SearchOBJ;

public interface IProductService extends IGenerateService<Product> {
    Iterable<Product> findAll ( );

    void reduceQuantity(Long id, int quantity);

    void reducePrice(Long id, double price);

    Iterable<Product> searchByGender(String gender);

    Iterable<Product> searchProductByName(String name);

    Iterable<Product> filter(SearchOBJ searchOBJ);

//    Iterable<OrderProduct> reportByYear(SearchOBJ searchOBJ);
//    Iterable<OrderProduct> reportByMonth(SearchOBJ searchOBJ);

}
