package com.myapp.traffic.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.traffic.dto.TrafficDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrafficApiClient {

    private static final RestTemplate restTemplate = new RestTemplate();
    private static final ObjectMapper mapper = new ObjectMapper();

    private static final String API_KEY = "(api인증키)"; //실시간 전국 교통량(한국도로공사)
    private static final String API_URL = "https://data.ex.co.kr/openapi/trafficapi/trafficAll";

    public static List<TrafficDto> fetchTrafficData() {
        String url = API_URL + "?key=" + API_KEY + "&type=json";


        List<TrafficDto> result = new ArrayList<>();

        try {
            String response = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(response);
            JsonNode items = root.path("trafficAll");

            if (items.isArray()) {
                for (JsonNode item : items) {
                    TrafficDto dto = new TrafficDto();
                    dto.setTmName(item.path("tmName").asText()); //시간
                    dto.setTcsName(item.path("tcsName").asText()); //통행구분
                    dto.setTrafficAmout(item.path("trafficAmout").asText()); //통행량
                    dto.setCarType(item.path("carType").asText()); //차종구분
                    result.add(dto);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

