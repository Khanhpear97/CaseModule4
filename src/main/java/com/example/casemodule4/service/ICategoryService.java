package com.example.casemodule4.service;

import com.example.casemodule4.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService extends IGenerateService<Category> {
    Iterable<Category> findAll();
}
