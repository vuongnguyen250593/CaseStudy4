package com.example.casestudy4_springboot.service;

import com.example.casestudy4_springboot.model.Category;

import java.util.Optional;

public interface ICategoryService {
    Iterable<Category> findAll();

    Optional<Category> findOne(Long id);

    Category save(Category category);

    void delete(Long id);
}
