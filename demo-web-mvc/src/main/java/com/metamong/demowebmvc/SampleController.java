package com.metamong.demowebmvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class SampleController {

    @GetMapping(
            value = "/hello",
            //headers = "!" + HttpHeaders.FROM
            headers = HttpHeaders.AUTHORIZATION + "=" + "123",
            params = {"name=metamong"}
    )
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
