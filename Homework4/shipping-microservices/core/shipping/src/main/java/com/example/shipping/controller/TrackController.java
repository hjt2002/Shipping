package com.example.shipping.controller;

import com.example.shipping.entity.Track;
import com.example.shipping.service.TrackService;
import com.example.shipping.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TrackController {
    final TrackService trackService;
    public TrackController(TrackService trackService){
        this.trackService = trackService;
    }
    @GetMapping("/getTrackById")
//    public JsonResult<Track>getTrackById(@RequestBody Map<String,String> map){
    public JsonResult<Track>getTrackById(@RequestParam Map<String,String> map){
        int shipperId = Integer.parseInt(map.get("shipperId"));
        int shipmentId = Integer.parseInt(map.get("shipmentId"));
        return trackService.getTrackById(shipperId,shipmentId);
    }
    @PostMapping("/addTrack")
    public JsonResult<String>addTrack(@RequestBody Track track){
        return trackService.addTrack(track);
    }
    @DeleteMapping("/deleteTrack")
    public JsonResult<String>deleteTrack(@RequestBody Map<String,String>map){
        int shipperId = Integer.parseInt(map.get("shipperId"));
        int shipmentId = Integer.parseInt(map.get("shipmentId"));
        return trackService.deleteTrack(shipperId,shipmentId);
    }
    @PostMapping("/modifyTrackStatus")
    public JsonResult<String>modifyTrackStatus(@RequestBody Map<String,String>map){
        String status = map.get("status");
        int shipperId = Integer.parseInt(map.get("shipperId"));
        int shipmentId = Integer.parseInt(map.get("shipmentId"));
        return trackService.modifyTrackStatus(status,shipperId,shipmentId);
    }

    @GetMapping ("/getTrackInfoById")
    public JsonResult<List<Map<String,Object>>>getTrackInfoById(@RequestParam Map<String,String>map){
        int shipmentId = Integer.parseInt(map.get("shipmentId"));
        return trackService.getTrackInfoById(shipmentId);
    }
    @PostMapping("/addTrackInfo")
    public JsonResult<String>addTrackInfo(@RequestBody Map<String,String>map) throws ParseException {
        int shipmentId = Integer.parseInt(map.get("shipmentId"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(map.get("date"));
        String location = map.get("location");
        String status = map.get("status");
        return trackService.addTrackInfo(shipmentId,date,location,status);
    }

}
