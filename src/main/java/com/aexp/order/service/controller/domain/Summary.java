package com.aexp.order.service.controller.domain;

import java.util.List;

public class Summary {


    private List<OrderSummary> orders;
    private float orderTotal;
    private int id;

    public Summary() {
    }

    public Summary(List<OrderSummary> orders, float total, int id) {
        this.orders = orders;
        this.orderTotal = total;
        this.id = id;
    }

    public float getOrderTotal() {
        return orderTotal;
    }

    public List<OrderSummary> getOrders() {
        return orders;
    }

    public int getId() {
        return id;
    }

    public void setOrders(List<OrderSummary> orders) {
        this.orders = orders;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void setId(int id) {
        this.id = id;
    }


}

