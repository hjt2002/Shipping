package com.example.shipping.controller;

import com.example.shipping.entity.Shipper;
import com.example.shipping.service.ShipperService;
import com.example.shipping.util.JsonResult;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ShipperController {
    final
    ShipperService shipperService;

    public ShipperController(ShipperService shipperService) {
        this.shipperService = shipperService;
    }

    @GetMapping ("/getShipperById")
    public JsonResult<Shipper> getShipperById(@RequestParam Map<String,String> map){
        // 获取Shipper
        int shipperId = Integer.parseInt(map.get("shipperId"));
        return shipperService.getShipperById(shipperId);
    }
    @PostMapping("/createShipper")
    public JsonResult<String> createShipper(@RequestBody Map<String,String>map){
        int shipperId = Integer.parseInt(map.get("shipperId"));
        String shipperName = map.get("shipperName");
        String email = map.get("email");
        String password = map.get("password");
        String shipperAddress = map.get("shipperAddress");
        Shipper shipper = new Shipper(shipperId,shipperName,email,password,shipperAddress);
        return shipperService.createShipper(shipper);
    }
}

