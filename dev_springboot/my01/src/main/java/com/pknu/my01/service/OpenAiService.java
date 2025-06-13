package com.pknu.my01.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenAiService {
    @Value("${openai.api.key}")
    private String apiKey;

    public String ask(String prompt){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        List<Map<String, Object>> messages = List.of(
            Map.of("role", "system", "content", "굉장히 불친절한 반말 진상 취객처럼 100자 이내로 정리해서 말해줘"),
            Map.of("role", "user", "content", prompt));
        
        Map<String, Object> body = Map.of(
            "model", "gpt-4.1-nano",
            "messages", messages,
            "temperature", 0,
            "max_tokens", 100,
            "presence_penalty", 0.6,
            "frequency_penalty", 0.5
        );
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        RestTemplate restTemplate = new RestTemplate();

        try{
            ResponseEntity<Map> response = restTemplate.exchange(
                "https://api.openai.com/v1/chat/completions",
                HttpMethod.POST,
                request,
                Map.class);
            List<Map<String, Object>> choices = (List<Map<String, Object>>) response.getBody().get("choices");
            Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
            return (String) message.get("content");
        } catch(Exception e){
            return "오류 : " + e.getMessage();
        }
    }
}

// top_p : 단어선택 확률 증가
// n : 몇 개의 응답을 생성할지
// user : 사용자 식별