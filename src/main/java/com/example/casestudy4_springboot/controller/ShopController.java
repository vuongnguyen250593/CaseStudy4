package com.example.casestudy4_springboot.controller;

import com.example.casestudy4_springboot.model.Category;
import com.example.casestudy4_springboot.model.Product;
import com.example.casestudy4_springboot.service.ICategoryService;
import com.example.casestudy4_springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICategoryService iCategoryService;


    @ModelAttribute(value = "categories")
    private Iterable<Category> findAll() {
        return iCategoryService.findAll();
    }

    @GetMapping("/showDisplay")
    public ModelAndView showProduct(@PageableDefault(value = 4) Pageable pageable, @RequestParam Optional<String> search) {
        ModelAndView modelAndView = new ModelAndView("shop");
        Page<Product> products;
        if (search.isPresent()) {
            products = iProductService.findAllByName(pageable, search.get());
            modelAndView.addObject("search", search.get());
        } else {
            products = iProductService.findAll(pageable);
        }
        modelAndView.addObject("product2s", products);
        return modelAndView;
    }

    @GetMapping("/desc")
    public ModelAndView sortByDesc(@SortDefault(sort = "price", direction = Sort.Direction.DESC)
                                   @PageableDefault(value = 4) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("shop");
        Page<Product> products = iProductService.findAll(pageable);
        modelAndView.addObject("product2s", products);
        return modelAndView;
    }


    @GetMapping("/asc")
    public ModelAndView sortByAsc(@SortDefault(sort = "price", direction = Sort.Direction.ASC)
                                  @PageableDefault(value = 4) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("shop");
        Page<Product> products = iProductService.findAll(pageable);
        modelAndView.addObject("product2s", products);
        return modelAndView;
    }

    @GetMapping("/view-category/{id}")
    public ModelAndView viewByCategory(@PathVariable Long id,
                                       @PageableDefault(value = 4) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("shop");
        Page<Product> products = iProductService.findAllByCategory(id, pageable);
        modelAndView.addObject("product2s", products);
        return modelAndView;
    }

    @GetMapping("/findPrice/{min}/{max}")
    public ModelAndView findByPrice(@PathVariable("min") double min, @PathVariable("max") double max, Pageable pageable ) {
        ModelAndView modelAndView = new ModelAndView("shop");
        Page<Product> products = iProductService.findAllByPriceBetween(min,max, pageable);
        modelAndView.addObject("product2s", products);
        return modelAndView;
    }
}