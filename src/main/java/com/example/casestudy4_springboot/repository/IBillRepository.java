package com.example.casestudy4_springboot.repository;

import com.example.casestudy4_springboot.model.Bill;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends PagingAndSortingRepository<Bill, Long> {
}
