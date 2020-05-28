package com.metamong.demojsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class EventController {

    @GetMapping("/events")
    public String getEvents(Model model) {
        Event event1 = new Event();
        event1.setName("Spring MVC Study 1th");
        event1.setStarts(LocalDateTime.of(2020, 5, 27, 10, 0));

        Event event2 = new Event();
        event2.setName("Spring MVC Study 2th");
        event2.setStarts(LocalDateTime.of(2020, 6, 4, 10, 0));

        List<Event> events = List.of(event1, event2);
        model.addAttribute("events", events);
        model.addAttribute("message", "Happy May");
        return "/events/list";
    }
}
