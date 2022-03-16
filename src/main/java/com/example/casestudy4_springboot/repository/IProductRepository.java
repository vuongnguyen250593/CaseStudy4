package com.example.casestudy4_springboot.repository;

import com.example.casestudy4_springboot.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
    Page<Product> findAllByNameContaining (Pageable pageable, String name);

    Page<Product> findProductsByCategory_Id (Long id, Pageable pageable);

    Page<Product> findAllByPriceBetween(double min, double max);


}
