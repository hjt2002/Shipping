package com.example.shipping.dao;

import com.example.shipping.entity.Track;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface TrackDao {
    Track getTrackById(int shipperId,int shipmentId);
    int addTrack(Track track);
    int deleteTrack(int shipperId,int shipmentId);
    int modifyTrackStatus(String status,int shipperId,int shipmentId);

    // 对货物信息追踪的接口实现
    List<Map<String,Object>>getTrackInfoById(int shipmentId);
    // 添加货物信息
    int addTrackInfo(int shipmentId, Date trackingDatetime,String location,String status);
}
