package com.wuqi.dev.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.wuqi.dev.entity.BookInfo;
import com.wuqi.dev.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/json")
public class JsonController {

    @Resource
    private BookService bookService;

    /*
    两个不同的请求返回相同的对象, 但是实际的JSON数据却可以不一样.
    使用Fastjson的@JsonView可以实现这样的功能, 详细写法除了下面还得看一下BookInfo这个类
     */
    @RequestMapping("/req1")
    @JsonView(BookInfo.SimpleView.class)
    public BookInfo req1(){
        return this.bookService.getOne();
    }

    @RequestMapping("/req2")
    @JsonView(BookInfo.DetailView.class)
    public BookInfo req2(){
        return this.bookService.getOne();
    }

}
