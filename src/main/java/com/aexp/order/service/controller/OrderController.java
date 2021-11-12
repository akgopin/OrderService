package com.aexp.order.service.controller;

import com.aexp.order.service.controller.domain.Order;
import com.aexp.order.service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Order receiveOrders(@RequestBody Order order) {
        return orderService.generateSummary(order);
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Order receiveOrders(@PathVariable int id) {
        return orderService.getOrder(id);
    }
}
