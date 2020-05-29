package com.metamong.demowebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SessionAttributes("event")
@Controller
public class SampleController {

    @GetMapping("/events/form")
    public String eventsForm(Model model) {
        Event newEvent = new Event();
        newEvent.setLimit(50);
        model.addAttribute("event", newEvent); // form backing object

        return "events/form";
    }

    @PostMapping("/events")
    public String createEvent(@Valid @ModelAttribute Event event, BindingResult bindingResult, SessionStatus sessionStatus) {
        if(bindingResult.hasErrors()) {
            return "/events/form";
        }

        // DB 처리

        sessionStatus.setComplete(); //세션 처리 완료
        return "redirect:/events/list"; // 중복 submit 방지 + RedirectView
    }

    @GetMapping("/events/list")
    public String getEvents(Model model) {

        // DB 읽어오기

        // e.g.
        Event event = new Event();
        event.setName("spring");
        event.setLimit(10);

        List<Event> eventList = new ArrayList<>();
        eventList.add(event);
        model.addAttribute("eventList", eventList); // attribute Name, Value 같을 때 Name 생략 가능

        return  "/events/list";
    }
}
