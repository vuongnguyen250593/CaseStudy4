package com.example.casestudy4_springboot.controller;

import com.example.casestudy4_springboot.model.Bill;
import com.example.casestudy4_springboot.model.CartDetail;
import com.example.casestudy4_springboot.model.User;
import com.example.casestudy4_springboot.repository.IBillRepository;
import com.example.casestudy4_springboot.service.IBillService;
import com.example.casestudy4_springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/user")
@SessionAttributes("cart")
public class BillController {

    @Autowired
    private IBillService billService;

    @GetMapping
    public ModelAndView showBill(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("shop-cart");
        Map<Long, CartDetail> cart = (Map<Long, CartDetail>) session.getAttribute("cart");
        if (cart == null) {
            modelAndView.addObject("carts", null);
        } else {
            modelAndView.addObject("carts", cart.values());
        }
        Optional<User> user = (Optional<User>) session.getAttribute("userInformation");
        modelAndView.addObject("userInformation", user.get());
        modelAndView.addObject("cartStats", CartDetail.cartStats(cart));
        return modelAndView;
    }

    @GetMapping("/bill-history/{id}")
    public ModelAndView showBillHistory(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("user-cart");
        Iterable<Bill> bills = billService.findBillByUserId(id);
        if (!bills.iterator().hasNext()) {
            modelAndView.addObject("bills", null);
        } else {
            modelAndView.addObject("bills", bills);
        }
        return modelAndView;
    }
}

