package com.aexp.order.service.domain;

public class product {

    private String name;
    private float price;


    public product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }


}
