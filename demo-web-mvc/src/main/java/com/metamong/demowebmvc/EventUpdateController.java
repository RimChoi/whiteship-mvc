package com.metamong.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

// consumes - 요청정보, produces - 응답정보
@RequestMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class EventUpdateController {
    @PostMapping(value = "/events", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String createEvent() {
        return "event";
    }

    @DeleteMapping("/events/{id}")
    @ResponseBody
    public String deleteEvent(@PathVariable int id) {
        return "event";
    }

    @PutMapping(value = "/events/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String updateEvent(@PathVariable int id) {
        return "event";
    }
}
