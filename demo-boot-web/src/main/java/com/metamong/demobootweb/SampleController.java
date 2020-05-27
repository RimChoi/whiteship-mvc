package com.metamong.demobootweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

    Logger logger = LoggerFactory.getLogger(SampleController.class);

    /**
     * 문자열 -> 객체, 객체 -> 문자열을 하려면 Formatter 가 필요하다.
     * WebMvcConfigurer 의 addFormatters 메소드 정의
     * @param person
     * @return
     */

    // 핸들러 인터셉터 process (동기적)
    // preHandle 1
    // preHandle 2
    // 요청처리
    // postHandler 2
    // postHandler 1
    // 뷰 렌더링
    // afterCompletion 2
    // afterCompletion 1
    @GetMapping(value = "/hello")
    public String hello(@RequestParam("id") Person person) {

        person.setType("pokemon");
        logger.info(person.toString());
        return "hello " + person.getName() + " (" + person.getType() + ")";
    }

    @GetMapping("/message")
    public @ResponseBody String message(@RequestBody String body) {
        return body;
    }
}
