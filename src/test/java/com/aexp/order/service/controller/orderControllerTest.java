package com.aexp.order.service.controller;


import com.aexp.order.service.controller.domain.Order;
import com.aexp.order.service.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.inject.Inject;

import com.aexp.order.service.OrderApplication;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@EnableWebMvc
@ContextConfiguration(classes = OrderApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class orderControllerTest {


    private MockMvc mockMvc;

    @Inject
    protected WebApplicationContext webApplicationContext;
    ;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testAcceptValidOrder() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = new Order("orange", 10);
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        mockMvc.perform(post("/order")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(orders)))
                .andExpect(status().isCreated());
    }
}
