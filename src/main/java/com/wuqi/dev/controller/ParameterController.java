package com.wuqi.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ParameterController {

    /*
    使用NativeWebRequest对象与使用HttpServletRequest一样,
    但是使用这个是有好处的: 可以避免在Controller中使用Servlet的API, 减少耦合.
    它提供了HttpServletRequest所具有的绝大部分功能.
     */
    @RequestMapping("/req1")
    public String req1(NativeWebRequest request){
        String key = "key";
        Object value = "value";
        // 1. 向Request域存数据
        request.setAttribute(key, value, RequestAttributes.SCOPE_REQUEST);
        // 2. 从Request域获取数据
        Object requestValue = request.getAttribute(key, RequestAttributes.SCOPE_REQUEST);
        // 3. 从Request域删除数据
        request.removeAttribute(key, RequestAttributes.SCOPE_REQUEST);
        // 4. 向Session域存数据
        request.setAttribute(key, value, RequestAttributes.SCOPE_SESSION);
        // 5. 从Session域获取数据
        Object sessionValue = request.getAttribute(key, RequestAttributes.SCOPE_SESSION);
        // 6. 从Session域删除数据
        request.removeAttribute(key, RequestAttributes.SCOPE_SESSION);
        // 7. 获取请求头中的数据
        String contentType = request.getHeader("Content-Type");
        // 8. 获取请求参数
        String page = request.getParameter("page");
        // 9. 获取contentPath
        String contextPath = request.getContextPath();
        // 10 获取原生的HttpServletRequest对象
        HttpServletRequest req = request.getNativeRequest(HttpServletRequest.class);
        // 更多API自行尝试
        return "success";
    }



}
