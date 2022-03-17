package com.example.casestudy4_springboot.repository;

import com.example.casestudy4_springboot.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBill_detailRepository extends JpaRepository<BillDetail, Long> {
    @Query("SELECT b FROM BillDetail b WHERE b.bill.id = :id")
    Iterable<BillDetail> findAllByBillId(long id);
}
