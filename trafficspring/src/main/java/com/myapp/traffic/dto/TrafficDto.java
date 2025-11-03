package com.myapp.traffic.dto;

public class TrafficDto {  //RequestDto
    private Long id;
    private String tcsName;
    private String trafficAmout;
    private String tmName;
    private String carType;

    public TrafficDto() {}

    public TrafficDto(Long id, String tcsName, String trafficAmout, String tmName, String carType) {
        this.id=id;
        this.tmName = tmName;
        this.trafficAmout = trafficAmout;
        this.tcsName = tcsName;
        this.carType = carType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }

    public String getTmName() {
        return tmName;
    }

    public void setTmName(String tmName) {
        this.tmName = tmName;
    }

    public String getTrafficAmout() {
        return trafficAmout;
    }

    public void setTrafficAmout(String trafficAmout) {
        this.trafficAmout = trafficAmout;
    }

    public String getTcsName() {
        return tcsName;
    }

    public void setTcsName(String tcsName) {
        this.tcsName = tcsName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    /*public Long id() {
        return id;
    }*/
}  //get, set 부분
