package com.aexp.order.service.repository;

import com.aexp.order.service.controller.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepo {
    Optional<List<Order>> findOrder(Integer orderId);

    Integer storeOrder(List<Order> orders);
}
