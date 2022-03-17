package com.example.casestudy4_springboot.controller;

import com.example.casestudy4_springboot.model.Category;
import com.example.casestudy4_springboot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping
    public ModelAndView showCategory() {
        ModelAndView modelAndView = new ModelAndView("admin-product-manager");
        Iterable<Category> categories = iCategoryService.findAll();
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }
}