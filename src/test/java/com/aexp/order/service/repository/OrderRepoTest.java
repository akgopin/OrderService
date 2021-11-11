package com.aexp.order.service.repository;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class OrderRepoTest {

    @Test
    public void TestValidOrder() {
        OrderRepo orderRepo = new OrderRepoImpl();
        ArrayList arrayList = new ArrayList<>();
        int orderId = orderRepo.storeOrder(arrayList);
        assertThat(orderRepo.findOrder(orderId).get(),equalTo(arrayList));

    }

    @Test
    public void TestInValidOrder() {
        OrderRepo orderRepo = new OrderRepoImpl();
        assertThat(orderRepo.findOrder(1),equalTo(Optional.empty()));
    }
}
