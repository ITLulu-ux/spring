/*package com.myapp.traffic.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.traffic.dto.TrafficDto;
import com.myapp.traffic.mapper.TrafficMapper;
import com.myapp.traffic.traffic.Traffic;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@Service
public class TrafficService {
    private final TrafficMapper trafficMapper;

    public TrafficService(TrafficMapper trafficMapper) {
        this.trafficMapper = trafficMapper;
    }

    public List<TrafficDto> getTrafficData() {
        try {
            ClassPathResource resource = new ClassPathResource("data/traffic.json"); //.json의 상위파일 경로는 resource
            InputStream is = resource.getInputStream();

            ObjectMapper mapper = new ObjectMapper();
            List<TrafficDto> list=Arrays.asList(mapper.readValue(is, TrafficDto[].class));

            int idx=0;
            for (TrafficDto dto : list) {
                System.out.println(">>> saving index=" + idx     //json 구성 출력
                        + " sumTime=" + dto.getSumTime()
                        + " conZoneName=" + dto.getConZoneName()
                        + " trafficAmount=" + dto.getTrafficAmount()
                        + " carType=" + dto.getCarType());

                Traffic e = new Traffic();
                e.setSumTime(dto.getSumTime());
                e.setConZoneName(dto.getConZoneName());
                // null 가능성이 있으면 기본값 처리
                //e.setTrafficAmount(dto.getTrafficAmount() !=null ? dto.getTrafficAmount() : 0);
                e.setCarType(dto.getCarType());

                //trafficRepository.save(e);
                //idx++;
            }

            return list;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read JSON file: " + e.getMessage());
        }
    }
}*/





