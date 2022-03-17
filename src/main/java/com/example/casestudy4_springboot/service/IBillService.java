package com.example.casestudy4_springboot.service;


import com.example.casestudy4_springboot.model.CartDetail;

import java.util.Map;

public interface IBillService {
    boolean addBill(Map<Long, CartDetail> cart);
}