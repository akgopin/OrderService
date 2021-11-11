package com.aexp.order.service.domain;

public class offer {

    private int goal;
    private String description;

    public offer(int goal, String description) {
        this.goal = goal;
        this.description = description;
    }

    public int getGoal() {
        return goal;
    }

    public String getDescription() {
        return description;
    }


}
