package com.wuqi.dev.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

@ContextConfiguration(value = "classpath:application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class RequestMappingControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void init() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void req1() throws Exception {
        // 构造第一个请求, 请求头中的Content-Type的值为application/x-www-form-urlencoded, 这个表示的是普通的表单请求
        MockHttpServletRequestBuilder req1 = MockMvcRequestBuilders.post("/mapping/req1")
                .header("Content-Type", "application/x-www-form-urlencoded");

        // 构造第二个请求, 请求头中的Content-Type的值为application/json
        MockHttpServletRequestBuilder req2 = MockMvcRequestBuilders.post("/mapping/req1")
                .header("Content-Type", "application/json");

        // 测试第一个请求, 响应码为200
        this.mockMvc.perform(req1)
                .andExpect(status().isOk())
                .andExpect(view().name("success"))
                .andExpect(forwardedUrl("/WEB-INF/views/success.jsp"));

        // 由于第二个请求的请求头不符合Controller中RequestMapping的声明, 所以响应码为415, 拒绝访问
        this.mockMvc.perform(req2)
                .andExpect(status().is(415));

    }

    @Test
    public void req2() throws Exception {
        // 构造第一个请求, 请求头中的Accept的值为application/json, 这个表示的是普通的表单请求
        MockHttpServletRequestBuilder req1 = MockMvcRequestBuilders.post("/mapping/req2")
                .header("Accept", "application/json");

        // 构造第二个请求, 请求头中的Accept的值为text/html
        MockHttpServletRequestBuilder req2 = MockMvcRequestBuilders.post("/mapping/req2")
                .header("Accept", "text/html");

        // 测试第一个请求, 响应码为200
        this.mockMvc.perform(req1)
                .andExpect(status().isOk());

        // 由于第二个请求的请求头Accept中不包含application/json的声明, 所以响应码为406, 拒绝访问
        this.mockMvc.perform(req2)
                .andExpect(status().is(406));
    }
}