package com.example.casestudy4_springboot.service.implement;

import com.example.casestudy4_springboot.model.Bill;
import com.example.casestudy4_springboot.model.BillDetail;
import com.example.casestudy4_springboot.model.CartDetail;
import com.example.casestudy4_springboot.repository.IBillRepository;
import com.example.casestudy4_springboot.repository.IUserRepository;
import com.example.casestudy4_springboot.service.IBillService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

@Service
public class BillService {

//    @Autowired
//    private IBillRepository billRepository;
//
//    @Override
//    public boolean addBill(Map<Long, CartDetail> cart) {
//        if (cart != null) {
//            return billRepository.addBill(cart);
//        }
//        return false;
//    }
}
