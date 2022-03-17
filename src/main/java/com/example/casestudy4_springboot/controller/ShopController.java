package com.example.casestudy4_springboot.controller;

import com.example.casestudy4_springboot.model.Product;
import com.example.casestudy4_springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/user")
public class ShopController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/shop-detail/{id}")
    public ModelAndView showDetail(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("shop-detail");
        Optional<Product> product = iProductService.findById(id);
        if (product.isPresent()) {
            modelAndView.addObject("product", product.get());
        } else {
            modelAndView.addObject("message", "Không có sản phẩm");
        }
        return modelAndView;
    }
}
