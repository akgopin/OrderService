package com.aexp.order.service.controller.domain;

import java.util.List;

public class Summary {


    private List<OrderSummary> orders;
    private float orderTotal;

    public Summary(List<OrderSummary> orders, float total) {
        this.orders = orders;
        this.orderTotal = total;
    }

    public float getOrderTotal() {
        return orderTotal;
    }

    public List<OrderSummary> getOrders() {
        return orders;
    }


}

