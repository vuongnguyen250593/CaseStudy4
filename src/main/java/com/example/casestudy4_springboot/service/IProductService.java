package com.example.casestudy4_springboot.service;

import com.example.casestudy4_springboot.model.Category;
import com.example.casestudy4_springboot.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService extends IGeneralService<Product> {
    Page<Product> findAll(Pageable pageable);

    Optional<Product> findOne(Long id);

    Product save(Product product);

    void delete(Long id);

    Page<Product> findAllByName(Pageable pageable, String name);

    Page<Product> findAllByCategory(Pageable pageable, Category category);
}
