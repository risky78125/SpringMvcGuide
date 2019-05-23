package com.wuqi.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ExceptionController {

    @RequestMapping("/req1")
    public String req1() {
        // 模拟在Controller的方法中抛出了异常, 并且没有处理.
        // **模拟** **模拟** **模拟** 真正项目里的这种异常都是需要处理掉的, 不会这么捕获
        // 这里用空指针异常做示例
        // 该异常会被当前类中的异常捕获方法所捕获
        throw new NullPointerException("在Controller中抛出的空指针异常");
    }

    @RequestMapping("/req2")
    public String req2() {
        // 这里用类型转换异常做示例
        // 该异常会被@ControllerAdvice注解的类所捕获, 详见ExceptionAdvice类
        throw new ClassCastException("在Controller中抛出类型转换异常");
    }

    /*
    该方法用来捕获在Controller中抛出了空指针异常, 并可以获取到异常对象
    需要注意的是该方法只会捕获当前Controller中抛出的异常.
    如果想捕获其它的Controller中的异常, 则需要将该方法声明到被@ControllerAdvice所注解的类中.
    该方法的返回值和参数的使用方式与Controller中的其它Handler方法一样.
     */
    @ExceptionHandler(NullPointerException.class)
    public String resolveNullPointerException(Model model, NullPointerException ex) {
        model.addAttribute("message", ex.getMessage());
        return "error";
    }

}
