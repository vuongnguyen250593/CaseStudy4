package com.example.casestudy4_springboot.model;

import java.util.HashMap;
import java.util.Map;

public class CartDetail {
    private Long id;
    private String name;
    private String image;
    private int quantity;
    private double price;

    public CartDetail() {
    }

    public CartDetail(Long id, String name, String image, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.image = image;
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

    public static double sumAmount(Map<Long, CartDetail> cart) {
        double sum = 0L;
        if (cart != null) {
            for (CartDetail c :
                    cart.values()) {
                sum += c.getQuantity() * c.getPrice();
            }
        }
        return sum;
    }

    public static Map<String, String> cartStats(Map<Long, CartDetail> cart) {
        double sum = 0L;
        int count = 0;
        if (cart != null) {
            for (CartDetail c :
                    cart.values()) {
                sum += c.getQuantity() * c.getPrice();
                count += c.getQuantity();
            }
        }
        Map<String, String> result = new HashMap<>();
        result.put("counter", String.valueOf(count));
        result.put("amount", String.valueOf(sum));
        return result;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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