package com.metamong.demowebmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SessionAttributes("event")
@Controller
public class EventController {

    @Autowired
    EventValidator eventValidator;


    @GetMapping("/events/form/name")
    public String eventsFormName(Model model) {
        throw new EventException();
//        model.addAttribute("event", new Event()); // form backing object
//        return "/events/form-name";
    }

    @PostMapping("/events/form/name")
    public String eventsForNameSubmit(@Valid @ModelAttribute Event event, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/events/form-name";
        }

        eventValidator.validate(event, bindingResult);

        // DB 처리

        return "redirect:/events/form/limit"; // 중복 submit 방지 + RedirectView
    }

    @GetMapping("/events/form/limit")
    public String eventsFormLimit(@ModelAttribute Event event, Model model) {

        model.addAttribute("event", event); // form backing object
        return "/events/form-limit";
    }

    @PostMapping("/events/form/limit")
    public String eventsForLimitSubmit(
            @Valid @ModelAttribute Event event,
            BindingResult bindingResult,
            SessionStatus sessionStatus,
            RedirectAttributes attributes
    ) {
        if(bindingResult.hasErrors()) {
            return "/events/form-limit";
        }

        // DB 처리

        sessionStatus.setComplete();
        attributes.addFlashAttribute("newEvent",event);

        return "redirect:/events/list"; // 중복 submit 방지 + RedirectView
    }

    /**
     * ModelAttribute 와 SessionAttribute 의 네이밍에 관해서.
     *
     * 같은 이름의 ModelAttribute 가 들어올 때, session 에서 찾게 되는데
     * 우리가 post 해서 받을때 session 을 비웠다 .. ERR
     * 명시적으로 이름을 다르게 해주셔라..
     *
     * 이걸로 1시간...ㅠㅠ...
     *
     */
    @GetMapping("/events/list")
    public String getEvents(
            Model model,
            @SessionAttribute LocalDateTime visitTime
    ) {

        // 혹은..
//        LocalDateTime time = (LocalDateTime) httpSession.getAttribute("visitTime");
//        System.out.println(time);

        System.out.println(visitTime);

        // DB 읽어오기

        System.out.println(model.getAttribute("newEvent") == null);
        List<Event> eventList = new ArrayList<>();

        if(model.asMap().size() == 1 && model.getAttribute("newEvent") == null) {
            Event mockEvent = new Event();
            mockEvent.setName("metamong");
            mockEvent.setLimit(20);
            eventList.add(mockEvent);
        } else {
            Event newEvent = (Event) model.asMap().get("newEvent");
            eventList.add(newEvent);
        }

        model.addAttribute("eventList", eventList); // attribute Name, Value 같을 때 Name 생략 가능

        return  "/events/list";
    }
}
