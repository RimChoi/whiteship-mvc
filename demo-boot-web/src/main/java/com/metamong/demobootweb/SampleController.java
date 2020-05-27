package com.metamong.demobootweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    Logger logger = LoggerFactory.getLogger(SampleController.class);

    /**
     * 문자열 -> 객체, 객체 -> 문자열을 하려면 Formatter 가 필요하다.
     * WebMvcConfigurer 의 addFormatters 메소드 정의
     * @param person
     * @return
     */
    @GetMapping(value = "/hello")
    public String hello(@RequestParam("id") Person person) {

        person.setType("pokemon");
        logger.info(person.toString());
        return "hello " + person.getName() + " (" + person.getType() + ")";
    }
}
