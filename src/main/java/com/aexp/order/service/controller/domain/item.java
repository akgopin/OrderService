package com.aexp.order.service.controller.domain;

public class item {

    private String name;
    private Integer quantity;
    private float price;

    public item(String name, Integer quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public item() {
    }

    public String getName() {
        return name;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
