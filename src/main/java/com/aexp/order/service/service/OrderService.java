package com.aexp.order.service.service;

import com.aexp.order.service.controller.domain.Order;

import java.util.List;


public interface OrderService {
    Order generateSummary(Order order) throws IllegalArgumentException;

    Order getOrder(Integer orderId) throws IllegalArgumentException;

    List<Order> getAllOrders();
}
