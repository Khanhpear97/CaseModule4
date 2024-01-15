package com.example.casemodule4.repository;


import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Long> {
    Iterable<Category> findAllByStatus(int status);
}