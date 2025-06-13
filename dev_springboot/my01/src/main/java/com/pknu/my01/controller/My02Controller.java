package com.pknu.my01.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pknu.my01.dto.ChatRequest;
import com.pknu.my01.service.OpenAiService;

@RestController
public class My02Controller {
    private final OpenAiService openAiService;

    public My02Controller(OpenAiService openAiService){
        this.openAiService = openAiService;
    }

    @PostMapping("/ex10")
    @ResponseBody
    public Map<String, String> chat(@RequestBody ChatRequest request){
        System.out.println(request.getMessage());
        String message = request.getMessage();
        String laughPattern = ".*ㅋ.*";
        String answer;
        if ("안녕".equals(message)){
            answer = "안녕은 반말이고";
        } else if (message.matches(laughPattern)){
            answer = "마 웃기나";
        } else if ("하이".equals(message)){
            answer = "영어 좀 치나";
        } else if ("안녕하세요".equals(message)){
            answer = "오냐";
        } else {
            answer = openAiService.ask(message);
        }
        return Map.of("reply", answer);
    }
}
