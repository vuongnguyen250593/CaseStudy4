package com.example.casestudy4_springboot.service.implement;

import com.example.casestudy4_springboot.model.Product;
import com.example.casestudy4_springboot.repository.IProductRepository;
import com.example.casestudy4_springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }
}
