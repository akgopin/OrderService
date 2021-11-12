package com.aexp.order.service.controller;


import com.aexp.order.service.controller.domain.Order;
import com.aexp.order.service.controller.domain.item;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.inject.Inject;

import com.aexp.order.service.OrderApplication;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@EnableWebMvc
@ContextConfiguration(classes = OrderApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class orderControllerTest {


    private MockMvc mockMvc;

    @Inject
    protected WebApplicationContext webApplicationContext;


    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testAcceptValidOrder() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = createOrder();
        MvcResult result = mockMvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(order)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        Order actualSummary = objectMapper.readValue(content, Order.class);


        List<item> expectedItems = new ArrayList<>();
        expectedItems.add(new item("orange", 15, 25.0F));
        Order expectedSummary = new Order(actualSummary.getId(), expectedItems, 250.0F);
        String expectedContent = objectMapper.writeValueAsString(expectedSummary);

        assertThat(content, equalTo(expectedContent));

    }


    @Test
    public void testGetOrder() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = createOrder();
        MvcResult result = mockMvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(order)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        Order actualSummary = objectMapper.readValue(content, Order.class);

        //Retrieving the order that was created and asserting on the response
        MvcResult getOrder = mockMvc.perform(get("/orders/" + actualSummary.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        List<item> expectedItems = new ArrayList<>();
        expectedItems.add(new item("orange", 15, 25.0F));
        Order expectedSummary = new Order(actualSummary.getId(), expectedItems, 250.0F);
        String expectedContent = objectMapper.writeValueAsString(expectedSummary);

        assertThat(content, equalTo(expectedContent));


    }

    private Order createOrder() {
        List<item> items = new ArrayList<>();
        item item = new item();
        item.setQuantity(10);
        item.setName("orange");
        items.add(item);
        Order order = new Order();
        order.setItems(items);
        return order;
    }

}
