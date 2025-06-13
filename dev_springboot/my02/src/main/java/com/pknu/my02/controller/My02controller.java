package com.pknu.my02.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class My02controller {
    @GetMapping("/api")
    public Map<String, String> Api() {
        Map<String, String> data = new HashMap<>();
        data.put("username", "username");
        data.put("password", "password");
        return data;
    }
    @PostMapping("/data")
    @ResponseBody
    public Map<String, String> rData(@RequestParam String usename, @RequestParam String password, Model model){
        System.out.println("이름" + usename + " / 비밀번호 " + password);

        Map<String, String> result = new HashMap<>();
        result.put("usename", usename);
        result.put("password", password);
        return result;
    }
    
    
}
