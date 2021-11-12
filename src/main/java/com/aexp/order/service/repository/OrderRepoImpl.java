package com.aexp.order.service.repository;

import com.aexp.order.service.controller.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class OrderRepoImpl implements OrderRepo {

    private Map<Integer, Order> orderStore = new HashMap();
    private int id = 0;


    @Override
    public Optional<Order> findOrder(Integer orderId) {
        Order order = orderStore.get(orderId);
        if (order != null) {
            return Optional.of(order);
        }
        return Optional.empty();
    }

    @Override
    public Integer storeOrder(Order orders) {
        orders.setId(++id);
        orderStore.put(id, orders);
        return id;
    }
}
