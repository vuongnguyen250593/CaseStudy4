package com.example.casestudy4_springboot.model;

import java.util.Map;

public class CartDetail {
    private Long id;
    private String name;
    private int quantity;
    private double price;

    public CartDetail() {
    }

    public CartDetail(Long id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public static int countCart(Map<Long, CartDetail> cart) {
        int count = 0;
        if (cart != null) {
            for (CartDetail c :
                    cart.values()) {
                count += c.getQuantity();
            }
        }
        return count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
