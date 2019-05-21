package com.wuqi.dev.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mapping")
public class RequestMappingController {

    /*
    只接收前端请求头中"Content-Type: application/x-www-form-urlencoded"的请求,
    如果请求头中不包含此字段, 则会返回415响应码
     */
    @RequestMapping(value = "/req1", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String req1() {
        return "success";
    }

    /*
    只接收前端Accept请求头中包含"application/json;charset=UTF-8"的请求,
    如果请求头的Accept字段中不包含此字段, 则会返回406响应码
     */
    @RequestMapping(value = "/req2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String req2() {
        return "success";
    }


}
