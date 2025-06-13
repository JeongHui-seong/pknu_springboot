package com.axios.axios.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AxController {
    @GetMapping("/api")
    @ResponseBody
    public Map<String, String> Api(){
        Map<String, String> data = new HashMap<>();
        data.put("data", "관련 자료");
        System.out.println("OKOK");
        return data;
    }

    @GetMapping("/list")
    @ResponseBody
    public Map<String, Object> List(){
        Map<String, Object> data = new HashMap<>();
        List<String> fruits = Arrays.asList("사과", "딸기", "바나나");
        data.put("list", fruits);
        System.out.println("OKOK");
        return data;
    }

    @PostMapping("/data")
    @ResponseBody
    public Map<String, String> Login(@RequestBody Map<String, String> payload){
        String name = payload.get("name");
        String age = payload.get("age");
        String memo = payload.get("memo");

        int parseAge = Integer.parseInt(age);
        String toStAge = Integer.toString(parseAge + 1);
        System.out.println("name : " + name + " / age : " + age + " / memo" + memo);
        Map<String, String> result = new HashMap<>();
        result.put("name", name + "님");
        result.put("age", toStAge);
        result.put("memo", memo + " 라고 잘 받았습니다.");
        return result;
    }
}
