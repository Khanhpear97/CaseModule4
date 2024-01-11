package com.example.casemodule4.repository;

import com.example.casemodule4.model.Category;
import com.example.casemodule4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
