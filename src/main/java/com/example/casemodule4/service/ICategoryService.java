package com.example.casemodule4.service;


import jdk.jfr.Category;

public interface ICategoryService extends IGenerateService<Category> {

    Object findALL ( );

    Iterable<Category> findAll ( );
}
