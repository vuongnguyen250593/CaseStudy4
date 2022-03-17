package com.example.casestudy4_springboot.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCard(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId() == product.getId()) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            Map.Entry<Product, Integer> integerEntry = selectItemInCard(product);
            Integer newQuantity = integerEntry.getValue() + 1;
            products.replace(integerEntry.getKey(), newQuantity);
        }
    }

    public void subProduct(Product product) {
        Map.Entry<Product, Integer> integerEntry = selectItemInCard(product);
        Integer newQuantity = integerEntry.getValue() - 1;
        products.replace(integerEntry.getKey(), newQuantity);
    }

    public Integer countProductQuantity() {
        Integer producQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            producQuantity += entry.getValue();
        }
        return producQuantity;
    }

    public Integer countItemQuantity() {
        return products.size();
    }

    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }

    public Double totalPrice(Product product) {
        Map.Entry<Product, Integer> integerEntry = selectItemInCard(product);
        Double total = integerEntry.getKey().getPrice() * integerEntry.getValue();
        return total;
    }
}