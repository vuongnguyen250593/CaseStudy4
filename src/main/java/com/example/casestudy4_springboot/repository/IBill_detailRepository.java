package com.example.casestudy4_springboot.repository;

import com.example.casestudy4_springboot.model.BillDetail;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBill_detailRepository extends PagingAndSortingRepository<BillDetail, Long> {
}
