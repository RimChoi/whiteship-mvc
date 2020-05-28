package com.metamong.demowebmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloTest() throws Exception {
        /**
         * 복 수의 파라미터테스트시 아래 링크 참조
         * (https://okky.kr/article/517350) 
         */
        this.mockMvc.perform(get("/hello"))
                .andDo(print())
                .andExpect(status().isOk())

        ;

    }

    // 37 강. HTTP 요청 맵핑하기 7부: 맵핑 연습 문제

    // 37-1
    @Test
    public void getEvents() throws Exception {

        this.mockMvc.perform(get("/events"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    // 37-2
    @Test
    public void getEventsWithId() throws Exception {
        this.mockMvc.perform(get("/events/1"))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/events/2"))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/events/3"))
                .andExpect(status().isOk());
    }

    // 37-3
    @Test
    public void createEvent() throws Exception {
        this.mockMvc.perform(post("/events")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    // 37-4
    @Test
    public void deleteEvent() throws Exception {
        this.mockMvc.perform(delete("/events/1"))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(delete("/events/2"))
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(delete("/events/3"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    // 37-5
    @Test
    public void updateEvent() throws Exception {
        this.mockMvc.perform(put("/events/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk());

        this.mockMvc.perform(put("/events/2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk());


    }

}