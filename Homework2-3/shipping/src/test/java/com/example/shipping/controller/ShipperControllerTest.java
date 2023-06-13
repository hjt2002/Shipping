package com.example.shipping.controller;

import com.example.shipping.entity.Shipper;
import com.example.shipping.service.ShipperService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShipperControllerTest {
    @Autowired
    ShipperService shipperService;
    @Test
    void getShipperById() {
        int shipperId = 1001;
        System.out.println(shipperService.getShipperById(shipperId).getData());
    }

    @Test
    void createShipper(){
        Shipper shipper = new Shipper(1002,"Adam",
                "1161297349@qq.com","20301007","上海浦东");
        System.out.println(shipperService.createShipper(shipper));
    }
}