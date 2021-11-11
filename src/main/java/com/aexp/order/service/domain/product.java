package com.aexp.order.service.domain;

public class product {

    private String name;
    private float price;
    private offer offer;


    public product(String name, float price, offer offer) {
        this.name = name;
        this.price = price;
        this.offer = offer;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public offer getOffer() {
        return offer;
    }


}
