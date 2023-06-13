package com.example.shipping.controller;

import com.example.shipping.entity.Track;
import com.example.shipping.service.TrackService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TrackControllerTest {
    @Autowired
    TrackService trackService;
    @Test
    void getTrackById() {
        int shipperId = 1001;
        int shipmentId = 100001;
        System.out.println(trackService.getTrackById(shipperId,shipmentId).toString());
    }

    @Test
    void addTrack() throws ParseException {
//        Date date1 = new Date(, Calendar.JUNE,24);
//        Date date2 = new Date(2023,Calendar.JUNE,27);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat.parse("2023-05-23");
        Date date2 = dateFormat.parse("2023-05-27");
        String status = "unshipped";
        Track track = new Track(1001,100002,date1,date2,status);
        System.out.println(trackService.addTrack(track).toString());
    }

    @Test
    void deleteTrack() {
        int shipperId = 1001;
        int shipmentId = 100002;
        System.out.println(trackService.deleteTrack(shipperId,shipmentId));
    }

    @Test
    void modifyTrackStatus() {
        String status = "shipped";
        int shipperId = 1001;
        int shipmentId = 100002;
        System.out.println(trackService.modifyTrackStatus(status,shipperId,shipmentId));
    }

    @Test
    void getTrackInfoById(){
        int shipmentId = 100001;
        System.out.println(trackService.getTrackInfoById(shipmentId));
    }
    @Test
    void addTrackInfo() throws ParseException {
        int shipmentId = 100002;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse("2023-05-24 10:02:25");
        String location = "北京昌平";
        String status = "shipping";
        System.out.println(trackService.addTrackInfo(shipmentId,date,location,status));
    }
}