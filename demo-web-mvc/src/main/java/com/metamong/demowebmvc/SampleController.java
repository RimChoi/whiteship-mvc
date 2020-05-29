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

@SessionAttributes("event")
@Controller
public class SampleController {

    @GetMapping("/events/form/name")
    public String eventsFormName(Model model) {
        model.addAttribute("event", new Event()); // form backing object
        return "/events/form-name";
    }

    @PostMapping("/events/form/name")
    public String eventsForNameSubmit(@Valid @ModelAttribute Event event, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/events/form-name";
        }

        // DB 처리

        return "redirect:/events/form/limit"; // 중복 submit 방지 + RedirectView
    }

    @GetMapping("/events/form/limit")
    public String eventsFormLimit(@ModelAttribute Event event, Model model) {

        model.addAttribute("event", event); // form backing object
        return "/events/form-limit";
    }

    @PostMapping("/events/form/limit")
    public String eventsForLimitSubmit(@Valid @ModelAttribute Event event, BindingResult bindingResult, SessionStatus sessionStatus) {
        if(bindingResult.hasErrors()) {
            return "/events/form-limit";
        }

        // DB 처리

//        sessionStatus.setComplete();
        return "redirect:/events/list"; // 중복 submit 방지 + RedirectView
    }

    @GetMapping("/events/list")
    public String getEvents(Model model, @ModelAttribute Event event) {

        // DB 읽어오기

        List<Event> eventList = new ArrayList<>();
        eventList.add(event);
        model.addAttribute("eventList", eventList); // attribute Name, Value 같을 때 Name 생략 가능

        return  "/events/list";
    }
}
