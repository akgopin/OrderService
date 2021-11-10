package com.aexp.order.service.service;

import com.aexp.order.service.controller.domain.Order;
import com.aexp.order.service.controller.domain.Summary;

import java.util.List;

public interface OrderService {
    Summary generateSummary(List<Order> orders) throws IllegalArgumentException;
}
