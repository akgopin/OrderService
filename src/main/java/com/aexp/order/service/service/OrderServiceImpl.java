package com.aexp.order.service.service;

import com.aexp.order.service.controller.domain.Order;
import com.aexp.order.service.controller.domain.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aexp.order.service.repository.productRepo;
import com.aexp.order.service.domain.product;
import com.aexp.order.service.controller.domain.OrderSummary;
import com.aexp.order.service.domain.offer;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private productRepo productRepo;

    @Autowired
    public OrderServiceImpl(productRepo productRepo) {
        this.productRepo = productRepo;
    }


    @Override
    public Summary generateSummary(List<Order> orders) throws IllegalArgumentException {
        List<OrderSummary> orderSummaries = new ArrayList<>();
        float totalCost = 0;
        for (Order order : orders) {
            product pro = productRepo.findProduct(order.getItem()).orElseThrow(IllegalArgumentException::new);
            float itemCost = calculateCostPerItem(order, pro);
            int quantity = applyOffer(pro.getOffer(), order.getQuantity());
            totalCost = getTotalCost(totalCost, itemCost);
            //preparing summary
            OrderSummary orderSummary = new OrderSummary(pro.getPrice(), itemCost, pro.getName(), quantity);
            orderSummaries.add(orderSummary);

        }
        return new Summary(orderSummaries, totalCost);
    }

    private float getTotalCost(float totalCost, float itemCost) {
        totalCost += itemCost;
        return totalCost;
    }

    private float calculateCostPerItem(Order order, product pro) {
        return order.getQuantity() * pro.getPrice();
    }

    private int applyOffer(offer offer, int quantity) {
        if (offer != null) {
            if (quantity > offer.getGoal()) {
                quantity += quantity / offer.getGoal();
            }
            return quantity;
        }
        return quantity;
    }
}
