package com.metamong.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class SampleController {

    @GetMapping("/events/{id}")
    @ResponseBody
    public Event getEvent(
            @PathVariable(required = false) Integer id // required 대신 Optional(java 1.8 이상) 을 사용 할 수 있다.
            , @MatrixVariable String name  // WebConfiguration 을 해주어야 사용가능.
    ) {
        Event event = new Event();
        event.setId(id);
        event.setName(name);
        return event;
    }
}
