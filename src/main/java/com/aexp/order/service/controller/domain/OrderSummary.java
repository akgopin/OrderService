package com.aexp.order.service.controller.domain;

public class OrderSummary extends Order {

    private float price;
    private float total;

    public OrderSummary(float price, float total, String name, int quantity) {
        super(name, quantity);
        this.price = price;
        this.total = total;
    }

    public float getPrice() {
        return price;
    }

    public float getTotal() {
        return total;
    }


}