package com.example.casestudy4_springboot.repository;

import com.example.casestudy4_springboot.model.Bill;
import com.example.casestudy4_springboot.model.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface IBillRepository {
    boolean addBill(Map<Long, CartDetail> cart);
}