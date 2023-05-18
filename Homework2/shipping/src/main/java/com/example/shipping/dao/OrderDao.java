package com.example.shipping.dao;

import com.example.shipping.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface OrderDao {
    Order getOrderById(int shipmentId);
    int createOrder(Order order);
    int deleteOrder(int shipmentId);
    Map<String,Object>getBillings(int shipmentId);
    int createBillings(Map<String,Object>map);
    int getShipmentId();
}
