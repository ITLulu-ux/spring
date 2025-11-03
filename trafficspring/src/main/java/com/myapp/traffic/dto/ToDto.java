package com.myapp.traffic.dto;

import com.myapp.traffic.traffic.Traffic;

public class ToDto {
    public static Traffic toEntity(TrafficDto dto) {
        Traffic entity = new Traffic();
        entity.setId(dto.getId());
        entity.setTmName(dto.getTmName());
        entity.setTcsName(dto.getTcsName());
        entity.setTrafficAmout(dto.getTrafficAmout());
        entity.setCarType(dto.getCarType());
        return entity;
    }
}
