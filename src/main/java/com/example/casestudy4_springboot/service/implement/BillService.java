package com.example.casestudy4_springboot.service.implement;

import com.example.casestudy4_springboot.model.Bill;
import com.example.casestudy4_springboot.model.BillDetail;
import com.example.casestudy4_springboot.model.CartDetail;
import com.example.casestudy4_springboot.model.Product;
import com.example.casestudy4_springboot.repository.IBillRepository;
import com.example.casestudy4_springboot.repository.IBill_detailRepository;
import com.example.casestudy4_springboot.repository.IProductRepository;
import com.example.casestudy4_springboot.service.IBillService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
public class BillService implements IBillService {

    @Autowired
    private IBillRepository billRepository;

    @Autowired
    private IBill_detailRepository bill_detailRepository;

    @Autowired
    private IProductRepository productRepository;



    @Override
    public void save(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public boolean addBill(Map<Long, CartDetail> cart, Bill bill) {
        try {
            if (cart != null) {
                Bill bill1 = new Bill();
                bill1.setUser(bill.getUser());
                bill1.setDate(bill.getDate());
                bill1.setNote(bill.getNote());
                bill1.setStatus(bill.getStatus());
                bill1.setTotal(bill.getTotal());
                billRepository.save(bill1);
                for (CartDetail c : cart.values()) {
                    Product product = productRepository.findProductById(c.getId());
                    BillDetail billDetail = new BillDetail();
                    billDetail.setProduct(c.getName());
                    billDetail.setImage(c.getImage());
                    billDetail.setQuantity(c.getQuantity());
                    billDetail.setTotalMoney(c.getPrice());
                    billDetail.setBill(bill1);
                    product.setQuantity(product.getQuantity() - billDetail.getQuantity());
                    bill_detailRepository.save(billDetail);
                }
                return true;
            } else {
                return false;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void deleteAll() {
        billRepository.deleteAll();
    }

    @Override
    public Iterable<Bill> findBillByUserId(long id) {
        return billRepository.findBillsByUserId(id);
    }
}
