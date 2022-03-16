package com.example.casestudy4_springboot.controller;

import com.example.casestudy4_springboot.model.Category;
import com.example.casestudy4_springboot.model.Product;
import com.example.casestudy4_springboot.service.ICategoryService;
import com.example.casestudy4_springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Category>> getAllCategory() {
        return new ResponseEntity<>(iCategoryService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> createNewCategory(@RequestBody Category category) {
        return new ResponseEntity<>(iCategoryService.save(category), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        Optional<Category> categoryOptional = iCategoryService.findById(id);
        return categoryOptional.map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        Optional<Category> categoryOptional = iCategoryService.findById(id);
        return categoryOptional.map(category1 -> {
            category.setId(category1.getId());
            return new ResponseEntity<>(iCategoryService.save(category), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable Long id) {
        Optional<Category> categoryOptional = iCategoryService.findById(id);
        return categoryOptional.map(category -> {
            iCategoryService.deleteById(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<Iterable<Product>> findAllProductByCategory(@PathVariable Long id) {
        Optional<Category> categoryOptional = iCategoryService.findById(id);
        return categoryOptional.map(category -> new ResponseEntity<>(productService.findAllByCategory(category),
                HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
