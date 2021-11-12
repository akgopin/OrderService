package com.aexp.order.service.repository;

import com.aexp.order.service.controller.domain.Order;

import java.util.Optional;

public interface OrderRepo {
    Optional<Order> findOrder(Integer orderId);

    Integer storeOrder(Order order);
}
