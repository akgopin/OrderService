package com.aexp.order.service.service;

import com.aexp.order.service.controller.domain.Order;
import com.aexp.order.service.controller.domain.Summary;
import com.aexp.order.service.repository.ProductRepoImpl;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;


public class OrderServiceTest {


    @Test
    public void TestValidOrders() {
        OrderService orderService = new OrderServiceImpl(new ProductRepoImpl());
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("orange", 10));
        orders.add(new Order("apple", 20));
        Summary summary = orderService.generateSummary(orders);
        assertThat(summary.getOrders().get(0).getPrice(), equalTo(25.0F));
        assertThat(summary.getOrders().get(1).getPrice(), equalTo(60.0F));
        assertThat(summary.getOrders().size(), equalTo(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestInvalidValidOrders() {
        OrderService orderService = new OrderServiceImpl(new ProductRepoImpl());
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("grape", 10));
        orderService.generateSummary(orders);
    }
}
