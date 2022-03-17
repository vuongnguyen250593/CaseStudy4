package com.example.casestudy4_springboot.controller;

import com.example.casestudy4_springboot.model.CartDetail;
import com.example.casestudy4_springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@CrossOrigin("*")
public class BillController {


    @GetMapping("/bill")
    public ModelAndView showBill(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("shop-cart");
        Map<Long, CartDetail> cart = (Map<Long, CartDetail>) session.getAttribute("cart");
        if (cart == null) {
            modelAndView.addObject("carts", null);
        } else {
            modelAndView.addObject("carts", cart.values());
        }
        modelAndView.addObject("cartStats", CartDetail.cartStats(cart));
        return modelAndView;
    }

}