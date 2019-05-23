package com.wuqi.dev.controller;

import com.wuqi.dev.entity.BookInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ParameterController {

    /*
    向Request和Session中存一些数据, 方便下面某些请求进行读取测试
     */
    @RequestMapping("/req0")
    public String req0(NativeWebRequest request){
        BookInfo book = new BookInfo();
        book.setBookId(1001L);
        book.setBookName("三国演义");
        request.setAttribute("requestBook", book, RequestAttributes.SCOPE_REQUEST);
        request.setAttribute("sessionBook", book, RequestAttributes.SCOPE_SESSION);
        return "forward:req4";
    }

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
        // 9. 获取contextPath
        String contextPath = request.getContextPath();
        // 10 获取原生的HttpServletRequest对象
        HttpServletRequest req = request.getNativeRequest(HttpServletRequest.class);
        // 更多API自行尝试
        return "success";
    }

    /*
    获取某个请求头数据
     */
    @RequestMapping("/req2")
    public String req2(@RequestHeader("User-Agent") String userAgent){
        return "success";
    }


    /*
    获取Cookie中某条数据
     */
    @RequestMapping("/req3")
    public String req3(@CookieValue("JSESSIONID") String sessionId){
        return "success";
    }

    /*
    从请求域中获取数据.
    required表示该数据是否为必需的.
    默认值为true, 如果从域中无法取出数据, 则会返回400响应码.
    下面的SessionAttribute同理.
     */
    @RequestMapping("/req4")
    public String req4(@RequestAttribute(value = "requestBook", required = false) BookInfo book){
        return "success";
    }

    /*
    从Session中获取数据
     */
    @RequestMapping("/req5")
    public String req5(@SessionAttribute("sessionBook") BookInfo book){
        return "success";
    }


}












