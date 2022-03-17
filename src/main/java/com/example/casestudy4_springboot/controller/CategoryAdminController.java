package com.example.casestudy4_springboot.controller;

import com.example.casestudy4_springboot.model.Category;
import com.example.casestudy4_springboot.model.Product;
import com.example.casestudy4_springboot.service.ICategoryService;
import com.example.casestudy4_springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryAdminController {
    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IProductService iProductService;

    @GetMapping
    public ModelAndView showCategory() {
        ModelAndView modelAndView = new ModelAndView("admin-product-manager");
        Iterable<Category> categories = iCategoryService.findAll();
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showProductByCategory(@PageableDefault(value = 10) Pageable pageable, @PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("admin-product-manager");
        Page<Product> productPage;
        Optional<Category> categoryOptional = iCategoryService.findOne(id);
        if (categoryOptional.isPresent()) {
            productPage = iProductService.findAllByCategory(pageable, categoryOptional.get());
            modelAndView.addObject("categories", categoryOptional.get());
        } else {
            productPage = iProductService.findAll(pageable);
        }
        modelAndView.addObject("products", productPage);
        return modelAndView;
    }
}
