package com.pknu.my01.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pknu.my01.dto.Bbang;
import com.pknu.my01.dto.MemberData;

@Controller
public class My01Controller {
    @GetMapping("/")
    public String mainPage(Model model){
        List<String> pageNames = List.of("ex01", "ex02", "ex03", "ex04","ex05","ex06", "ex07", "ex08", "ex09", "ex10", "ex10a");
        model.addAttribute("pages", pageNames);
        return "index";
    }
    @GetMapping("/ex01")
    public String ex01(Model model){
        model.addAttribute("hello", "만나서 반가워요. 스프링 부트 ex01");
        return "ex01";
    }
    @GetMapping("/ex02")
    public String ex02(Model model){
        List<Integer> sampleNumbers = List.of(1,2,3,4,5,6,7);
        model.addAttribute("numbers", sampleNumbers);
        return "ex02";
    }
    @GetMapping("/ex03")
    public String ex03(Model model){
        return "ex03";
    }
    @GetMapping("/ex04")
    public String ex04(Model model){
        model.addAttribute("isAdmin", true);
        model.addAttribute("who", "me");
        List<String> items = new ArrayList<>();
        items.add("사과");
        items.add("복숭아");
        items.add("바나나");
        items.add("수박");
        items.add("망고");
        items.add("포도");
        items.add("참외");
        model.addAttribute("items", items);
        return "ex04";
    }
    @GetMapping("/ex05")
    public String ex05(Model model){
        MemberData member = new MemberData("홍길동", LocalDate.of(2001, 5, 5));
        MemberData smember = new MemberData("슈퍼맨", LocalDate.of(2002, 6, 6));
        model.addAttribute("member", member);
        model.addAttribute("smember", smember);
        return "ex05";
    }
    @GetMapping("/ex06")
    public String ex06(Model model){
        List<Bbang> bungs = List.of(
            new Bbang("팥", 1000, LocalDate.of(2025,6,4)),
            new Bbang("슈크림", 1100, LocalDate.of(2025,6,3))
        );
        model.addAttribute("bungs", bungs);
        return "ex06";
    }
    @GetMapping("/ex07")
    public String ex07(@RequestParam(required = false) String inpName, String inpAge, String inpGender, String allow, String want, Model model){
        System.out.println(inpName);
        System.out.println(inpAge);
        System.out.println(inpGender);
        System.out.println(allow);
        System.out.println(want);
        List<String> content = List.of(
            inpName, inpAge, inpGender, allow, want
        );
        model.addAttribute("content", content);
        return "ex07";
    }
    @GetMapping({"/ex08","/ex08/{name}","/ex08/{name}/{age}"})
    public String ex08(@PathVariable(required = false) String name, @PathVariable(required = false) String age, Model model){
        System.out.println("이름" + name +  "/ 나이" + age);
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "ex08";
    }
    @GetMapping("/ex09")
    public String ex09(){
        return "ex09";
    }
    @PostMapping("/ex09")
    public String ex09Post(@RequestParam String inpName, @RequestParam String inpAge, Model model){
        // System.out.println("이름" + inpName + " / 나이 " + inpAge);
        // model.addAttribute("inpName", inpName);
        // model.addAttribute("inpAge", inpAge);
        
        try{
            int parseAge = Integer.parseInt(inpAge);
            model.addAttribute("inpName", inpName);
            model.addAttribute("inpAge", parseAge);
        }
        catch(NumberFormatException e){
            model.addAttribute("error", "나이는 숫자로 입력해주세요.");
        }
        return "ex09";
    }
    @GetMapping("/ex10")
    public String ex10(Model model){
        return "ex10";
    }
    @GetMapping("/ex10a")
    public String ex10a(Model model){
        return "ex10a";
    }
}
