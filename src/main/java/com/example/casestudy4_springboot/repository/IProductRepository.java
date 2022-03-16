package com.example.casestudy4_springboot.repository;

import com.example.casestudy4_springboot.model.Category;
import com.example.casestudy4_springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    Iterable<Product> findAllByCategory(Category category);
}
