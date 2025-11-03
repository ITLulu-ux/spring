/*package com.myapp.traffic.controller;

import com.myapp.traffic.dto.TrafficDto;
import com.myapp.traffic.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/traffic")
public class TrafficController {

    private final TrafficService trafficService;

    @Autowired
    public TrafficController(TrafficService trafficService) {
        this.trafficService = trafficService;
    }

    @GetMapping("/info")
    public List<TrafficDto> getTrafficInfo() throws IOException {
        return trafficService.getTrafficData();
    }
}*/
