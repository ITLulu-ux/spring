package com.myapp.traffic.service;

import com.myapp.traffic.client.TrafficApiClient;
import com.myapp.traffic.dto.FromDto;
import com.myapp.traffic.dto.ToDto;
import com.myapp.traffic.dto.TrafficDto;
import com.myapp.traffic.mapper.TrafficMapper;
import com.myapp.traffic.traffic.Traffic;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListService {
    private final TrafficMapper trafficMapper;
    private final TrafficApiClient trafficApiClient;
    private Long id;

    @Transactional
    public void saveFromApi() {
        List<TrafficDto> trafficList = trafficApiClient.fetchTrafficData();
        List<TrafficDto> apiData = trafficApiClient.fetchTrafficData();
        for (TrafficDto dto : trafficList) {
            Traffic entity = ToDto.toEntity(dto);
            trafficMapper.insert(entity);
        }
    }

    @Transactional(readOnly=true)
    public List<TrafficDto> list() { //맨 처음
        List<Traffic> trafficEntities = (List<Traffic>) trafficMapper.selectAll();
        return trafficEntities.stream()
                .map(FromDto::fromEntity)
                .collect(Collectors.toList());
        }

    @Transactional(readOnly = true)
    public TrafficDto view(Long id) { //각 리스트
        Traffic traffic = trafficMapper.findById(id);
        if(traffic ==null) {
            return null;    //얘가 실행되는 듯 함
            //return FromDto.fromEntity(traffic);
        }
        return FromDto.fromEntity(traffic);
    }

    /*@Transactional
    public TrafficDto insert(TrafficDto dto) {//조회?
        Traffic entity= ToDto.toEntity(dto);
        trafficMapper.insert(entity);
        return dto;
    }*/  //없어도 되는 코드

    @Transactional
    public TrafficDto update(TrafficDto dto) throws Exception { //수정
        Traffic entity=ToDto.toEntity(dto);
        System.out.println("DTO ID: " + dto.getId());
        System.out.println("DTO tmName: " + dto.getTmName());
        System.out.println("DTO tcsName: " + dto.getTcsName());
        System.out.println("DTO trafficAmout: " + dto.getTrafficAmout());
        System.out.println("DTO carType: " + dto.getCarType());
        trafficMapper.update(entity);
        return dto;
    }

    @Transactional
    public void delete(Long id) { //삭제
        trafficMapper.delete(id);
    }
}
