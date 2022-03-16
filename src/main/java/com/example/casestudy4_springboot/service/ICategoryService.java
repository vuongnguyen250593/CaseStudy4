package com.example.casestudy4_springboot.service;

import com.example.casestudy4_springboot.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService extends IGeneralService<Category> {

    Page<Category> findAll(Pageable pageable);
}
