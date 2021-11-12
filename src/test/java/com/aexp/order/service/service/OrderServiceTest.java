package com.aexp.order.service.service;

import com.aexp.order.service.controller.domain.Order;
import com.aexp.order.service.repository.OrderRepoImpl;
import com.aexp.order.service.repository.ProductRepoImpl;
import org.junit.Test;
import com.aexp.order.service.controller.domain.item;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class OrderServiceTest {


    @Test
    public void TestValidOrders_evenQuantities() {
        OrderService orderService = new OrderServiceImpl(new ProductRepoImpl(), new OrderRepoImpl());
        List<item> items = new ArrayList<>();
        items.add(new item("orange", 10,10.0F));
        items.add(new item("apple", 20,20.0F));
        Order order = new Order();
        order.setItems(items);
        Order orderSummary = orderService.generateSummary(order);
        assertThat(orderSummary.getItems().size(), equalTo(2));
        assertThat(orderSummary.getItems().get(0).getPrice(), equalTo(25.0F));
        assertThat(orderSummary.getItems().get(0).getQuantity(), equalTo(15));
        assertThat(orderSummary.getItems().get(1).getPrice(), equalTo(60.0F));
        assertThat(orderSummary.getItems().get(1).getQuantity(), equalTo(40));
        assertThat(orderSummary.getTotal(), equalTo(1450.0F));
    }

    @Test
    public void TestValidOrders_oddQuantities() {
        OrderService orderService = new OrderServiceImpl(new ProductRepoImpl(), new OrderRepoImpl());
        List<item> items = new ArrayList<>();
        items.add(new item("orange", 9,10.0F));
        items.add(new item("apple", 17,20.0F));
        Order order = new Order();
        order.setItems(items);
        Order orderSummary = orderService.generateSummary(order);
        assertThat(orderSummary.getItems().size(), equalTo(2));
        assertThat(orderSummary.getItems().get(0).getPrice(), equalTo(25.0F));
        assertThat(orderSummary.getItems().get(0).getQuantity(), equalTo(13));
        assertThat(orderSummary.getItems().get(1).getPrice(), equalTo(60.0F));
        assertThat(orderSummary.getItems().get(1).getQuantity(), equalTo(34));
        assertThat(orderSummary.getTotal(), equalTo(1245.0F));
    }

    @Test
    public void TestValidOrders_NoOfferApplied() {
        OrderService orderService = new OrderServiceImpl(new ProductRepoImpl(), new OrderRepoImpl());
        List<item> items = new ArrayList<>();
        items.add(new item("orange", 1,10.0F));
        Order order = new Order();
        order.setItems(items);
        Order orderSummary = orderService.generateSummary(order);
        assertThat(orderSummary.getItems().size(), equalTo(1));
        assertThat(orderSummary.getItems().get(0).getPrice(), equalTo(25.0F));
        assertThat(orderSummary.getItems().get(0).getQuantity(), equalTo(1));
    }

    @Test
    public void TestGetOrderById() {
        OrderService orderService = new OrderServiceImpl(new ProductRepoImpl(), new OrderRepoImpl());
        List<item> items = new ArrayList<>();
        items.add(new item("orange", 1,10.0F));
        Order order = new Order();
        order.setItems(items);
        Order orderSummary = orderService.generateSummary(order);

        int id = orderSummary.getId();
        assertThat(id, greaterThan(0));

        assertThat(orderService.getOrder(id), not(Optional.empty()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestInvalidValidOrders() {
        OrderService orderService = new OrderServiceImpl(new ProductRepoImpl(), new OrderRepoImpl());
        List<item> items = new ArrayList<>();
        items.add(new item("grapes", 1,10.0F));
        Order order = new Order();
        order.setItems(items);
        orderService.generateSummary(order);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestOrderNotFound() {
        OrderService orderService = new OrderServiceImpl(new ProductRepoImpl(), new OrderRepoImpl());
        orderService.getOrder(1);
    }

}
