package com.example.shipping.controller;

import com.example.shipping.entity.Order;
import com.example.shipping.service.OrderService;
import com.example.shipping.util.JsonResult;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class OrderController {
    final
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getOrderById")
    public JsonResult<Order> getOrderById(@RequestParam Map<String,String>map){
        int shipmentId = Integer.parseInt(map.get("shipmentId"));
        return orderService.getOrderById(shipmentId);
    }

    @PostMapping("/createOrder")
    public JsonResult<String> createOrder(@RequestBody Order order){
        return orderService.createOrder(order);
    }

    @DeleteMapping("/deleteOrder")
    public JsonResult<String>deleteOrder(@RequestBody Map<String,String>map){
        int shipmentId = Integer.parseInt(map.get("shipmentId"));
        return orderService.deleteOrder(shipmentId);
    }
    @GetMapping("/getBillingsById")
    public JsonResult<Map<String,Object>>getBillingsById(@RequestParam Map<String,String>map){
        int shipmentId = Integer.parseInt(map.get("shipmentId"));
        return orderService.getBillingsById(shipmentId);
    }
    @PostMapping("/createBillings")
    public JsonResult<String>createBillings(@RequestBody Map<String,Object>map){
        return orderService.createBillings(map);
    }

    @GetMapping("/getShipmentId")
    public JsonResult<Integer>getShipmentId(){
        return orderService.getShipmentId();
    }
}
