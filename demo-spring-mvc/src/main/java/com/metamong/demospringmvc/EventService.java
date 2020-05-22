package com.metamong.demospringmvc;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {
    public List<Event> getEvents() {
        Event event1 = Event.builder()
                .name("Spring Web Study 1st")
                .limitOfEnrollment(5)
                .startDataTime(LocalDateTime.of(2020,1, 10, 0, 0))
                .endDataTime(LocalDateTime.of(2020, 1, 10, 2, 0))
                .build();

        Event event2 = Event.builder()
                .name("Spring Web Study 2nd")
                .limitOfEnrollment(5)
                .startDataTime(LocalDateTime.of(2020,1, 10, 0, 0))
                .endDataTime(LocalDateTime.of(2020, 1, 10, 2, 0))
                .build();

        return List.of(event1, event2);
    }
}
