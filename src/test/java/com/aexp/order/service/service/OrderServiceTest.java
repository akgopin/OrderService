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
    public void TestValidOrders_evenQuantities() {
        OrderService orderService = new OrderServiceImpl(new ProductRepoImpl());
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("orange", 10));
        orders.add(new Order("apple", 20));
        Summary summary = orderService.generateSummary(orders);
        assertThat(summary.getOrders().size(), equalTo(2));
        assertThat(summary.getOrders().get(0).getPrice(), equalTo(25.0F));
        assertThat(summary.getOrders().get(0).getQuantity(), equalTo(15));
        assertThat(summary.getOrders().get(1).getPrice(), equalTo(60.0F));
        assertThat(summary.getOrders().get(1).getQuantity(), equalTo(40));
        assertThat(summary.getOrderTotal(), equalTo(1450.0F));
    }

    @Test
    public void TestValidOrders_oddQuantities() {
        OrderService orderService = new OrderServiceImpl(new ProductRepoImpl());
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("orange", 9));
        orders.add(new Order("apple", 17));
        Summary summary = orderService.generateSummary(orders);
        assertThat(summary.getOrders().size(), equalTo(2));
        assertThat(summary.getOrders().get(0).getPrice(), equalTo(25.0F));
        assertThat(summary.getOrders().get(0).getQuantity(), equalTo(13));
        assertThat(summary.getOrders().get(1).getPrice(), equalTo(60.0F));
        assertThat(summary.getOrders().get(1).getQuantity(), equalTo(34));
        assertThat(summary.getOrderTotal(), equalTo(1245.0F));
    }

    @Test
    public void TestValidOrders_NoOfferApplied() {
        OrderService orderService = new OrderServiceImpl(new ProductRepoImpl());
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("orange", 1));
        Summary summary = orderService.generateSummary(orders);
        assertThat(summary.getOrders().size(), equalTo(1));
        assertThat(summary.getOrders().get(0).getPrice(), equalTo(25.0F));
        assertThat(summary.getOrders().get(0).getQuantity(), equalTo(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestInvalidValidOrders() {
        OrderService orderService = new OrderServiceImpl(new ProductRepoImpl());
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("grape", 10));
        orderService.generateSummary(orders);
    }
}
