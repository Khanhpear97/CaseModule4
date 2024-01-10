package com.example.casemodule4.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGenerateService<T> {
    Page<T> findAll(Pageable pageable);

    void save(T t);

    void remove(Long id);

    T findById(Long id);
}
