package com.example.casestudy4_springboot.model;


import javax.persistence.*;

@Entity
@Table(name = "bill_detail")
public class BillDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    private String image;

    private int quantity;

    private double totalMoney;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    public BillDetail() {
    }

    public BillDetail(Long id, String product, String image, int quantity, double totalMoney, Bill bill) {
        this.id = id;
        this.product = product;
        this.image = image;
        this.quantity = quantity;
        this.totalMoney = totalMoney;
        this.bill = bill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}