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

    /*
    params属性用来对请求参数进行规定, 取值有如下方式
    例如:
    params = "browser=chrome": 规定请求中必须携带browser=chrome的参数
    params = "browser!=chrome": 规定请求中必须携带browser=chrome的参数
    params = "browser": 规定请求中必须携带browser参数, 取值随意.
        符合规范的请求如下所示: /req3?browser; /req3?browser=; /req3?browser=null; /req3?browser=xxx
    params = "!browser": 规定请求中必须不能携带browser参数
    如果请求不符合上述的约定, 那么会返回400响应码
     */
    @RequestMapping(value = "/req3", params = "browser")
    public String req3() {
        return "success";
    }


}
