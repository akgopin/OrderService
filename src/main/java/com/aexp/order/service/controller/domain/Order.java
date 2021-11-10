package com.aexp.order.service.controller.domain;


public class Order {

    private String item;
    private Integer quantity;

    public Order(String item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Order() {
    }


    public String getItem() {
        return item;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
