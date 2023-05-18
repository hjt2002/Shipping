package com.example.shipping.controller;

import com.example.shipping.entity.Order;
import com.example.shipping.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@SpringBootTest
class OrderControllerTest {
    @Autowired
    OrderService orderService;

    @Test
    void getOrderById() {
        int shipmentId = 100001;
        System.out.println(orderService.getOrderById(shipmentId).toString());
    }

    @Test
    void createOrder() {
        Order order = new Order(100003,"赵先生","北京海淀","汽车",1000);
        System.out.println(orderService.createOrder(order).toString());
    }

    @Test
    void deleteOrder() {
        int shipmentId = 100003;
        System.out.println(orderService.deleteOrder(shipmentId).toString());
    }

    @Test
    void getBillingsById() {
        int shipmentId = 100001;
        System.out.println(orderService.getBillingsById(shipmentId).toString());
    }
    @Test
    void createBillings(){
        int shipment_id = 100003;
        int amount = 200;
        Date date = new Date();
        String status = "pending";
        Map<String,Object>map = new HashMap<>();
        map.put("shipmentId",shipment_id);
        map.put("amount",amount);
        map.put("duedate",date);
        map.put("status",status);
        System.out.println(orderService.createBillings(map));
    }
}