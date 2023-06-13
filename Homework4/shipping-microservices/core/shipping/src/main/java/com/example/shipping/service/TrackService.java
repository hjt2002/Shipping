package com.example.shipping.service;

import com.example.shipping.dao.TrackDao;
import com.example.shipping.entity.Track;
import com.example.shipping.util.JsonResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TrackService {
    final TrackDao trackDao;
    public TrackService(TrackDao trackDao){
        this.trackDao = trackDao;
    }

    public JsonResult<Track>getTrackById(int shipperId,int shipmentId){
        Track track = trackDao.getTrackById(shipperId,shipmentId);
        if(track!=null){
            return new JsonResult<>(track);
        }else
            return new JsonResult<>("0","查询失败");
    }
    public JsonResult<String>addTrack(Track track){
        if(trackDao.addTrack(track)!=0){
            return new JsonResult<>("1","创建成功");
        }else
            return new JsonResult<>("0","创建失败");
    }
    public JsonResult<String>deleteTrack(int shipperId,int shipmentId){
        if(trackDao.deleteTrack(shipperId,shipmentId)!=0){
            return new JsonResult<>("1","删除成功");
        }else
            return new JsonResult<>("0","删除失败");
    }
    public JsonResult<String>modifyTrackStatus(String status,int shipperId,int shipmentId){
        if(trackDao.modifyTrackStatus(status,shipperId,shipmentId)!=0){
            return new JsonResult<>("1","修改成功");
        }else
            return new JsonResult<>("0","修改失败");
    }

    // 货物信息追踪
    public JsonResult<List<Map<String,Object>>>getTrackInfoById(int shipmentId){
        List<Map<String,Object>> list = trackDao.getTrackInfoById(shipmentId);
        if(!list.isEmpty()){
            return new JsonResult<>(list);
        }else {
            return new JsonResult<>("0","查询失败");
        }
    }

    // 添加货物信息
    public JsonResult<String>addTrackInfo(int shipmentId, Date trackingDatetime,String location,String status){
        if(trackDao.addTrackInfo(shipmentId,trackingDatetime,location,status)!=0){
            return new JsonResult<>("1","添加成功");
        }else {
            return new JsonResult<>("0","添加失败");
        }
    }
}
