package com.example.casemodule4.controller;

import org.springframework.http.ResponseEntity;

public interface IGeneralController<T> {
    ResponseEntity<Iterable<T>> list();

    ResponseEntity<T> create(T t);

    ResponseEntity<T> update(T t);

    ResponseEntity<T> delete(Long id);
}
