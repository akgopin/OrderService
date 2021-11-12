package com.aexp.order.service.service;

import com.aexp.order.service.controller.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aexp.order.service.repository.productRepo;
import com.aexp.order.service.domain.product;
import com.aexp.order.service.domain.offer;
import com.aexp.order.service.repository.OrderRepo;
import com.aexp.order.service.controller.domain.item;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    private productRepo productRepo;
    private OrderRepo orderRepo;

    @Autowired
    public OrderServiceImpl(productRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }


    @Override
    public Order generateSummary(Order order) throws IllegalArgumentException {
        float totalCost = 0;
        for (item item : order.getItems()) {
            product pro = productRepo.findProduct(item.getName()).orElseThrow(IllegalArgumentException::new);
            float itemCost = calculateCostPerItem(item, pro);
            int quantity = applyOffer(pro.getOffer(), item.getQuantity());
            totalCost = getTotalCost(totalCost, itemCost);
            //preparing summary
            item.setPrice(pro.getPrice());
            item.setQuantity(quantity);

        }
        order.setTotal(totalCost);
        orderRepo.storeOrder(order);
        return order;
    }

    @Override
    public Order getOrder(Integer orderId) throws IllegalArgumentException {
        return orderRepo.findOrder(orderId).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAllOrders();
    }

    private float getTotalCost(float totalCost, float itemCost) {
        totalCost += itemCost;
        return totalCost;
    }

    private float calculateCostPerItem(item item, product pro) {
        return item.getQuantity() * pro.getPrice();
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
