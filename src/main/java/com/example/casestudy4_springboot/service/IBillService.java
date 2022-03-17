package com.example.casestudy4_springboot.service;


import com.example.casestudy4_springboot.model.Bill;
import com.example.casestudy4_springboot.model.CartDetail;

import java.util.Map;

public interface IBillService {
    void save(Bill bill);
    boolean addBill(Map<Long, CartDetail> cart, Bill bill);
    void deleteAll();
    Iterable<Bill> findBillByUserId(long id);
}
