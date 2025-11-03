package com.myapp.traffic.controller;

import com.myapp.traffic.dto.TrafficDto;
import com.myapp.traffic.service.ListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/traffic")//@RestController - 리턴값을 html 이름으로 해석하지 않고, 그대로 문자열로 반환
@RequiredArgsConstructor
public class ListController {
    private final ListService listService;

    @GetMapping("/sync")
    public String syncFromApi() {
        listService.saveFromApi();
        return "redirect:/traffic/list";
    }

    @GetMapping("/list") //맨 처음
    public String list(Model model) {
        List<TrafficDto> traffic=listService.list();
        model.addAttribute("traffic", traffic);
        return "list";
    }

    @GetMapping("/view/{id}") //각 리스트
    public String view(@PathVariable Long id, Model model) throws IllegalAccessException {
        TrafficDto traffic =listService.view(id);
        model.addAttribute("traffic", traffic);
        return "view";
    }

    @GetMapping("/form")
    public String form(@RequestParam Long id, Model model) throws IllegalAccessException {
        TrafficDto trafficDto=listService.view(id);
        System.out.println("Form Load - DTO ID from DB: " + trafficDto.getId());
        if(trafficDto !=null) {
            model.addAttribute("dto", trafficDto);
        }else {
            model.addAttribute("dto", new TrafficDto());
        }

        return "form";
    }

    /*@PostMapping("/insert") //수정
    public String insert(@ModelAttribute TrafficDto dto) {
       listService.insert(dto);
        return "form";
    }*/  //없어도 되는 코드

    @PostMapping("/update") //수정해서 저장
    public String update(@ModelAttribute TrafficDto dto) throws Exception{
        dto.getId();
        if (dto.getId() == null) {
            // 오류 처리 또는 기본 경로로 리다이렉트
            System.out.println("DTO ID: " + dto.getId());
            System.out.println("DTO tmName: " + dto.getTmName());
            System.out.println("DTO tcsName: " + dto.getTcsName());
            System.out.println("DTO trafficAmout: " + dto.getTrafficAmout());
            System.out.println("DTO carType: " + dto.getCarType());
            return "redirect:/traffic/list"; //redirect:errorPage면 errorPage로 이동
        }
        listService.update(dto);
        return "redirect:/traffic/list";
    }


    @PostMapping("/delete/{id}") //삭제
    public String delete(@PathVariable Long id) {
        listService.delete(id);
        return "redirect:/traffic/list";
    }
}
