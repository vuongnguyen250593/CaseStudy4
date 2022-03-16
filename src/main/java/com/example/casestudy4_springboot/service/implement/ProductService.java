package com.example.casestudy4_springboot.service.implement;

import com.example.casestudy4_springboot.model.Category;
import com.example.casestudy4_springboot.model.Product;
import com.example.casestudy4_springboot.repository.IProductRepository;
import com.example.casestudy4_springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return iProductRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public Iterable<Product> findAllByCategory(Category category) {
        return iProductRepository.findAllByCategory(category);
    }
}
