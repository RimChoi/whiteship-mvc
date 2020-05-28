package com.metamong.demowebmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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
        this.mockMvc.perform(get("/hello/metamong"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello Metamong"))
                .andExpect(handler().handlerType(SampleController.class))
                .andExpect(handler().methodName("helloMetamong"))
        ;

        this.mockMvc.perform(get("/hello/metamong.xml"))
                .andDo(print())
                .andExpect(status().isNotFound())
        ;

    }

}