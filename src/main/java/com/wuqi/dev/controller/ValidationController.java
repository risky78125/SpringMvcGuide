package com.wuqi.dev.controller;

import com.wuqi.dev.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/validate")
public class ValidationController {

    @RequestMapping("/page")
    public String page() {
        return "validate_page";
    }

    @RequestMapping("/login")
    public String login(@Validated(UserInfo.LoginGroup.class) UserInfo user) {
        return "success";
    }

    @RequestMapping("/register")
    public String register(@Validated(UserInfo.RegisterGroup.class) UserInfo user) {
        return "success";
    }

}
