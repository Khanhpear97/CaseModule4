package com.example.casemodule4.service;

import com.example.casemodule4.model.Category;

public interface ICategoryService extends IGenerateService<Category> {

    Object findALL ( );

    Iterable<Category> findAll ( );
}
