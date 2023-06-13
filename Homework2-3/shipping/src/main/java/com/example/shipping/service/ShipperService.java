package com.example.shipping.service;

import com.example.shipping.dao.ShipperDao;
import com.example.shipping.entity.Shipper;
import com.example.shipping.util.JsonResult;
import org.springframework.stereotype.Service;

@Service
public class ShipperService {
    final
    ShipperDao shipperDao;

    public ShipperService(ShipperDao shipperDao) {
        this.shipperDao = shipperDao;
    }
    public JsonResult<Shipper>getShipperById(int shipperId){
        Shipper shipper = shipperDao.getShipperById(shipperId);
        if (shipper != null){
            return new JsonResult<>(shipper);
        }else {
            return new JsonResult<>("0","未查询到用户");
        }
    }

    public JsonResult<String> createShipper(Shipper shipper){
        if(shipperDao.createShipper(shipper)!=0){
            return new JsonResult<>("1","账户创建成功");
        }else {
            return new JsonResult<>("1","账户创建失败");
        }
    }
}
