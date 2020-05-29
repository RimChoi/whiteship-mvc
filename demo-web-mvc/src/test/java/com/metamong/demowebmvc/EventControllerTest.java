package com.metamong.demowebmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class EventControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void eventForm() throws Exception {
        MockHttpServletRequest request = this.mockMvc.perform(get("/events/form"))
                .andDo(print())
                .andExpect(view().name("events/form"))
                .andExpect(model().attributeExists("event"))
                .andExpect(request().sessionAttribute("event", notNullValue()))
                .andReturn().getRequest();

        Object event = request.getSession().getAttribute("event");
        System.out.println(event);

    }

    @Test
    public void postEvent() throws Exception {
        ResultActions result = this.mockMvc.perform(post("/events")
                .param("name", "metamong")
                .param("limit", "-10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().hasErrors());

        ModelAndView mv = result.andReturn().getModelAndView();
        Map<String, Object> model = mv.getModel();
        System.out.println(model.size());

    }

    @Test
    public void getEvents() throws Exception {
        Event newEvent = new Event();
        newEvent.setName("Summer is Comming ..");
        newEvent.setLimit(2020);

        this.mockMvc.perform(get("/events/list")
                    .flashAttr("newEvent", newEvent)
                    .sessionAttr("visitTime", LocalDateTime.now()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("categories"));
    }

}