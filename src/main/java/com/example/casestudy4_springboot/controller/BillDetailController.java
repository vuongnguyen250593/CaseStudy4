package com.example.casestudy4_springboot.controller;

import com.example.casestudy4_springboot.model.BillDetail;
import com.example.casestudy4_springboot.service.IBill_detailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class BillDetailController {
    @Autowired
    private IBill_detailService bill_detailService;

    @GetMapping("/bill-detail/{id}")
    public ModelAndView getAllBillDetail(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView("user-cart-detail");
        Iterable<BillDetail> billDetails = bill_detailService.findBillDetailByBillId(id);
        if (!billDetails.iterator().hasNext()) {
            modelAndView.addObject("billDetail", null);
        } else {
            modelAndView.addObject("billDetail", billDetails);
        }
        return modelAndView;
    }
}
