package com.aexp.order.service.service;

import com.aexp.order.service.controller.domain.Order;
import com.aexp.order.service.controller.domain.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aexp.order.service.repository.productRepo;
import com.aexp.order.service.domain.product;
import com.aexp.order.service.controller.domain.OrderSummary;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private productRepo productRepo;

    @Autowired
    public  OrderServiceImpl(productRepo productRepo){
        this.productRepo = productRepo;
    }


    @Override
    public Summary generateSummary(List<Order> orders) throws IllegalArgumentException {
        List<OrderSummary> orderSummaries = new ArrayList<>();
        float cost = 0;
        for (Order order : orders) {
            product pro = productRepo.findProduct(order.getItem()).orElseThrow(IllegalArgumentException::new);
            float price = order.getQuantity() * pro.getPrice();
            OrderSummary orderSummary = new OrderSummary(price, pro.getName(), order.getQuantity());
            cost += price;
            orderSummaries.add(orderSummary);

        }
        return new Summary(orderSummaries, cost);
    }
}
