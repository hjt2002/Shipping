package com.example.shipping.service;

import com.example.shipping.dao.OrderDao;
import com.example.shipping.entity.Order;
import com.example.shipping.util.JsonResult;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderService {
    final
    OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public JsonResult<Order> getOrderById(int shipmentId){
        Order order = orderDao.getOrderById(shipmentId);
        if(order!=null){
            return new JsonResult<>(order);
        }else {
            return new JsonResult<>("0","获取失败");
        }
    }
    public JsonResult<String> createOrder(Order order){
        if(orderDao.createOrder(order)!=0){
            return new JsonResult<>("1","创建成功");
        }else {
            return new JsonResult<>("0","创建失败");
        }
    }
    public JsonResult<String> deleteOrder(int shipmentId){
        if(orderDao.deleteOrder(shipmentId)!=0){
            return new JsonResult<>("1","删除成功");
        }else {
            return new JsonResult<>("0","删除失败");
        }
    }
    public JsonResult<Map<String,Object>>getBillingsById(int shipmentId){
        Map<String,Object> map = orderDao.getBillings(shipmentId);
        if(!map.isEmpty()) {
            return new JsonResult<>(map);
        }else
            return new JsonResult<>("0","查询失败");
    }
    public JsonResult<String>createBillings(Map<String,Object>map){
        if(orderDao.createBillings(map)!=0){
            return new JsonResult<>("1","添加成功");
        }else
            return new JsonResult<>("0","添加失败");
    }

    public JsonResult<Integer>getShipmentId(){
        int shipmentId = orderDao.getShipmentId();
        if(shipmentId!=0){
            return new JsonResult<>(shipmentId+1);
        }else
            return new JsonResult<>("0","查询失败");
    }
}
