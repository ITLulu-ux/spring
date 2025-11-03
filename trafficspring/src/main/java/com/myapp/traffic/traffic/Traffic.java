package com.myapp.traffic.traffic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Traffic {
    private Long id;
    private String tmName;
    private String tcsName;
    private String trafficAmout;
    private String carType;
}

