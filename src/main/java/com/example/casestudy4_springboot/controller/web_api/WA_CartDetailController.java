package com.example.casestudy4_springboot.controller.web_api;

import com.example.casestudy4_springboot.model.Bill;
import com.example.casestudy4_springboot.model.Cart;
import com.example.casestudy4_springboot.model.CartDetail;
import com.example.casestudy4_springboot.model.Product;
import com.example.casestudy4_springboot.service.IBillService;
import com.example.casestudy4_springboot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/api")
public class WA_CartDetailController {

    @Autowired
    private IBillService billService;

    @PostMapping("/cart")
    public int addToCart(@RequestBody CartDetail cartDetail, HttpSession session) {
        Map<Long, CartDetail> cart = (Map<Long, CartDetail>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        long productId = cartDetail.getId();
        if (cart.containsKey(productId)) {
            CartDetail c = cart.get(productId);
            c.setQuantity(c.getQuantity() + 1);
        } else {
            cart.put(productId, cartDetail);
        }
        session.setAttribute("cart", cart);
        return CartDetail.countCart(cart);
    }


    @PutMapping("/cart")
    public ResponseEntity<Map<String, String>> updateCart(@RequestBody CartDetail cartDetail, HttpSession session) {
        Map<Long, CartDetail> cart = (Map<Long, CartDetail>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        long productId = cartDetail.getId();
        if (cart.containsKey(productId)) {
            CartDetail c = cart.get(productId);
            c.setQuantity(cartDetail.getQuantity());
        }
        session.setAttribute("cart", cart);
        return new ResponseEntity<>(CartDetail.cartStats(cart), HttpStatus.OK);
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<Map<String, String>> deleteCartItem(@PathVariable long id, HttpSession session) {
        Map<Long, CartDetail> cart = (Map<Long, CartDetail>) session.getAttribute("cart");
        if (cart != null && cart.containsKey(id)) {
            cart.remove(id);
            session.setAttribute("cart", cart);
        }
        return new ResponseEntity<>(CartDetail.cartStats(cart), HttpStatus.OK);
    }

    @GetMapping("/cart/totalPrice")
    public ResponseEntity<Map<String, String>> totalPrice(HttpSession session) {
        Map<Long, CartDetail> cart = (Map<Long, CartDetail>) session.getAttribute("cart");
        return new ResponseEntity<>(CartDetail.cartStats(cart), HttpStatus.OK);
    }

//    count product
    @GetMapping("/cart")
    public int count(HttpSession session) {
        Map<Long, CartDetail> cart = (Map<Long, CartDetail>) session.getAttribute("cart");
        return CartDetail.countCart(cart);
    }

    @PostMapping("/pay")
    public HttpStatus pay(@RequestBody Bill bill, HttpSession session) {
        if (billService.addBill((Map<Long, CartDetail>) session.getAttribute("cart"),bill)) {
            session.removeAttribute("cart");
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }
}
