package com.aexp.order.service.controller.domain;


import java.util.List;

public class Order {

    private Integer id;
    private List<item> items;
    private float total;

    public Order(Integer id, List<item> items, float total) {
        this.id = id;
        this.items = items;
        this.total = total;
    }


    public Order() {
        
    }


    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<item> getItems() {
        return items;
    }

    public void setItems(List<item> items) {
        this.items = items;
    }


}
