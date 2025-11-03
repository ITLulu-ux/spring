package com.myapp.traffic.dto;

import com.myapp.traffic.traffic.Traffic;

public class FromDto {
    public static TrafficDto fromEntity(Traffic entity) {
        TrafficDto dto = new TrafficDto();
        dto.setId(entity.getId());
        dto.setTmName(entity.getTmName());
        dto.setTcsName(entity.getTcsName());
        dto.setTrafficAmout(entity.getTrafficAmout());
        dto.setCarType(entity.getCarType());
        return dto;
    }
}
