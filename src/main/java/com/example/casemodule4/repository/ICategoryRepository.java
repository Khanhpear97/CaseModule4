package com.example.casemodule4.repository;

import com.example.casemodule4.model.Category;
import com.example.casemodule4.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
//    @Query("SELECT c FROM Category c WHERE c.name LIKE %?1%")
//    List<Category>
}
