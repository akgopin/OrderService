package com.aexp.order.service.controller.domain;

public class OrderSummary extends Order {

    private float price;

    public OrderSummary(float price, String name, int quantity) {
        super(name, quantity);
        this.price = price;
    }

    public float getPrice() {
        return price;
    }


}