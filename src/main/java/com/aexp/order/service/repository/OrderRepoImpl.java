package com.aexp.order.service.repository;

import com.aexp.order.service.controller.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class OrderRepoImpl implements OrderRepo {

    Map<Integer, List<Order>> orderStore = new HashMap();
    int id = 0;


    @Override
    public Optional<List<Order>> findOrder(Integer orderId) {
        List<Order> orders = orderStore.get(orderId);
        if (orders != null) {
            return Optional.of(orders);
        }
        return Optional.empty();
    }

    @Override
    public Integer storeOrder(List<Order> orders) {
        orderStore.put(++id, orders);
        return id;
    }
}
