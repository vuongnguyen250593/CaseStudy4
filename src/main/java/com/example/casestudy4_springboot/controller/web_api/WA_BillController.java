package com.example.casestudy4_springboot.controller.web_api;

import com.example.casestudy4_springboot.model.Cart;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/api")
public class WA_BillController {

    @GetMapping("/bill")
    public ResponseEntity<Map<Long, Cart>> bill(HttpSession session) {
        Map<Long, Cart> cart = (Map<Long, Cart>) session.getAttribute("cart");
        if (cart == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
}
