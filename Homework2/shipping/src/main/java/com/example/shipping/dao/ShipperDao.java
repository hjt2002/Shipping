package com.example.shipping.dao;

import com.example.shipping.entity.Shipper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShipperDao {
    Shipper getShipperById(int shipperId);
    int createShipper(Shipper shipper);

}
