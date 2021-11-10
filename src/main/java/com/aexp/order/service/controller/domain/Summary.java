package com.aexp.order.service.controller.domain;

import java.util.List;

public class Summary {


    private List<OrderSummary> orders;
    private float total;

    public Summary(List<OrderSummary> orders, float total) {
        this.orders = orders;
        this.total = total;
    }

    public float getTotal() {
        return total;
    }

    public List<OrderSummary> getOrders() {
        return orders;
    }


}

