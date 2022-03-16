package com.example.casestudy4_springboot.service.implement;

import com.example.casestudy4_springboot.model.Bill;
import com.example.casestudy4_springboot.model.BillDetail;
import com.example.casestudy4_springboot.model.CartDetail;
import com.example.casestudy4_springboot.repository.IBillRepository;
import com.example.casestudy4_springboot.repository.IUserRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;
import java.util.Objects;


public class BillRepository{

    @Autowired
    private IUserRepository userRepository;


//    @Autowired
//    private LocalSessionFactoryBean sessionFactoryBean;
//
//    @Override
//    @Transactional(propagation = Propagation.REQUIRED)
//    public boolean addBill(Map<Long, CartDetail> cart) {
//        try {
//            Session session = Objects.requireNonNull(sessionFactoryBean.getObject()).getCurrentSession();
//            Bill bill = new Bill();
//            bill.setUser(userRepository.getById(6L));
//            bill.setDate(new Date());
//            Map<String, String> stats = CartDetail.cartStats(cart);
//            bill.setTotal(Double.parseDouble(stats.get("amount")));
//            session.save(bill);
//
//            for (CartDetail c :
//                    cart.values()) {
//                BillDetail b = new BillDetail();
//                b.setBill(bill);
//                b.setImage(c.getImage());
//                b.setProduct(c.getName());
//                b.setQuantity(c.getQuantity());
//                b.setTotalMoney(c.getPrice());
//
//                session.save(b);
//            }
//            return true;
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
}
