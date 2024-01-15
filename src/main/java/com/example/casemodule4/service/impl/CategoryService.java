package com.example.casemodule4.service.impl;

import com.example.casemodule4.repository.ICategoryRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final ICategoryRepository iCategoryRepository;

    @Autowired
    public CategoryService(ICategoryRepository iCategoryRepository) {

        this.iCategoryRepository = iCategoryRepository;
    }

//    public Category iCategoryRepository(Category category) {
//
//        return iCategoryRepository.save(Category category);
//    }
////
//    public List<Category> getAllCategories() {
//
//        return iCategoryRepository.findAll();
//    }
//
//    public Category getCategoryById(Long id) {
//        return iCategoryRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
//    }
//
//    public Category updateCategory(Long id, Category updatedCategory) {
//        Category category = getCategoryById(id);
//        category.setName(updatedCategory.getName());
//        return iCategoryRepository.save(category);
//    }

    public void deleteCategory(Long id) {
        iCategoryRepository.deleteById(id);
    }

    public Category createCategory (Category category) {
        return null;
    }

    public Category updateCategory (Long id, Category category) {
        return null;
    }

    public Category getCategoryById (Long id) {
return null;
    }

    public List<Category> getAllCategories ( ) {
        return null;
    }
}
