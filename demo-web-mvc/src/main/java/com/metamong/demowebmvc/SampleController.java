package com.metamong.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(consumes = MediaType.APPLICATION_XML_VALUE)
public class SampleController {

    @GetMapping(
            value = "/hello",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE) // 이런 경우에는 consumes 가 복수의 타입을 지원 x, 오버라이드 한다.

    @ResponseBody
    public String hello() {
        return "hello";
    }
}
