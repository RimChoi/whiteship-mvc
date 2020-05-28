package com.metamong.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(method = RequestMethod.GET)
public class SampleController {

    // method 를 지정하지 않으면, 모든 HTTP method 허용.
//    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.PUT})
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
