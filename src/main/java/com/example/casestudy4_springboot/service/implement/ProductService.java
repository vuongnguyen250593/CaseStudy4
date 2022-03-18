package com.example.casestudy4_springboot.service.implement;

import com.example.casestudy4_springboot.model.Category;
import com.example.casestudy4_springboot.model.Product;
import com.example.casestudy4_springboot.repository.IProductRepository;
import com.example.casestudy4_springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Optional<Product> findById(long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void deleteById(long id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findOne(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return iProductRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAllByName(Pageable pageable, String name) {
        return iProductRepository.findAllByNameContaining(pageable, name);
    }

    @Override
    public Page<Product> findAllByCategory(long id, Pageable pageable) {
        return iProductRepository.findProductsByCategory_Id(id, pageable);
    }

    @Override
    public Page<Product> findAllByPriceBetween(double min, double max, Pageable pageable) {
        return iProductRepository.findAllByPriceBetween(min,max, pageable);
    }
}
