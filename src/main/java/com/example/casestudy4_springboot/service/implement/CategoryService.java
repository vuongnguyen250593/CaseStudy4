package com.example.casestudy4_springboot.service.implement;

import com.example.casestudy4_springboot.model.Category;
import com.example.casestudy4_springboot.repository.ICategoryRepository;
import com.example.casestudy4_springboot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Category> findById(Long id) {
        return iCategoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return iCategoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        iCategoryRepository.deleteById(id);
    }
}
