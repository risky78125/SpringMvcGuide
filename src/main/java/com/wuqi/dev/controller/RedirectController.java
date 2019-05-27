package com.wuqi.dev.controller;

import com.wuqi.dev.entity.BookInfo;
import com.wuqi.dev.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/redirect")
public class RedirectController {

    // 当访问/page1请求时, 会重定向到/page2页面, 并且把数据传递过去
    // 需要注意的是调用RedirectAttributes.addAttribute方法也可以传递数据,
    // 只不过是通过浏览器的查询参数进行传递的.
    // 而使用addFlashAttribute的方式不会走浏览器.
    @RequestMapping("/page1")
    public String page1(RedirectAttributes attrs) {
        BookInfo book = new BookInfo();
        book.setBookId(1001L);
        book.setBookName("三国演义");
        book.setPublisher("个人出版社");
        attrs.addFlashAttribute("custom", book);
        return "redirect:page2";
    }

    @RequestMapping("/page2")
    public String page2(@ModelAttribute("custom") BookInfo book) {
        System.out.println(book);
        return "success";
    }

}
