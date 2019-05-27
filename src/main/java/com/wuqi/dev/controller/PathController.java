package com.wuqi.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/path")
public class PathController {

    @RequestMapping("/{fileName:[0-9a-zA-Z]+}.{ext:[a-zA-Z]+}")
    public String info(@PathVariable String fileName, @PathVariable String ext) {
        System.out.println(fileName);
        System.out.println(ext);
        return "success";
    }


}
