package com.metamong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public @ResponseBody String hello() {
        return "Hello, " + helloService.getName();
    }

    /**
     * RequestToViewNameTranslator 이용
     *  (핸들러에서 뷰 이름을 명시적으로 리턴하지 않은 경우,
     *  요청을 기반으로 뷰 이름을 판단하는 인터페이스)
     */
//    @GetMapping("/")
//    public void sample() {
//
//    }

    @GetMapping("/sample")
    public String sample() {
//        return "/WEB-INF/sample.jsp";
        return "sample";
    }
}
