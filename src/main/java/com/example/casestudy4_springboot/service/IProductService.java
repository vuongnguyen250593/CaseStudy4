package com.example.casestudy4_springboot.service;

import com.example.casestudy4_springboot.model.Category;
import com.example.casestudy4_springboot.model.Product;

public interface IProductService extends IGeneralService<Product> {

    Iterable<Product> findAllByCategory(Category category);
}
