package com.wuqi.dev.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


public class PathControllerTest extends BaseControllerTest {

    @Test
    public void info() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/path/images.jpg");
        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("success"));
    }
}