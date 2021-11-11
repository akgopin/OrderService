package com.aexp.order.service.controller;

import com.aexp.order.service.controller.domain.Order;
import com.aexp.order.service.controller.domain.Summary;
import com.aexp.order.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Summary receiveOrders(@RequestBody List<Order> orders) {
        return orderService.generateSummary(orders);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Order> receiveOrders(@PathVariable int id) {
        return orderService.getOrder(id);
    }
}
