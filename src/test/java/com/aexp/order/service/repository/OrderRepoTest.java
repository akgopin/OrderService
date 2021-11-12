package com.aexp.order.service.repository;

import com.aexp.order.service.controller.domain.Order;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class OrderRepoTest {

    @Test
    public void TestValidOrder() {
        OrderRepo orderRepo = new OrderRepoImpl();
        Order order = new Order();
        int orderId = orderRepo.storeOrder(order);
        assertThat(orderRepo.findOrder(orderId).get(),equalTo(order));

    }

    @Test
    public void TestInValidOrder() {
        OrderRepo orderRepo = new OrderRepoImpl();
        assertThat(orderRepo.findOrder(1),equalTo(Optional.empty()));
    }

    @Test
    public void TestGetAllOrders() {
        OrderRepo orderRepo = new OrderRepoImpl();
        Order order = new Order();
        orderRepo.storeOrder(order);
        assertThat(orderRepo.findAllOrders().get(0),equalTo(order));

    }
}
