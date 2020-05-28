package com.metamong.demowebmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
public class SampleController {

    @GetHelloMapping
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @PostMapping("/hello")
    @ResponseBody
    public String helloPost() {
        return "hello";
    }

    @GetMapping("/events")
    @ResponseBody
    public String events() {
        return "events";
    }

    @GetMapping("/events/{id}")
    @ResponseBody
    public String getAnEvents(@PathVariable int id) {
        return "events";
    }

}
