package com.example.casestudy4_springboot.service.implement;

import com.example.casestudy4_springboot.model.BillDetail;
import com.example.casestudy4_springboot.repository.IBill_detailRepository;
import com.example.casestudy4_springboot.service.IBill_detailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Bill_detailService implements IBill_detailService {

    @Autowired
    private IBill_detailRepository bill_detailRepository;

    @Override
    public void save(BillDetail billDetail) {
        bill_detailRepository.save(billDetail);
    }

    @Override
    public Iterable<BillDetail> findBillDetailByBillId(long id) {
        return bill_detailRepository.findAllByBillId(id);
    }
}
