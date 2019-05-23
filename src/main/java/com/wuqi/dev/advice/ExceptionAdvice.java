package com.wuqi.dev.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Map;

// basePackages属性表示针对哪个包下的Controller生效
// 除了使用basePackages属性来指定范围还可以通过其它方式, 查看属性名就能明白, 比较简单, 不做过多介绍.
@ControllerAdvice(basePackages = "com.wuqi.dev.controller")
public class ExceptionAdvice {

    @ExceptionHandler(ClassCastException.class)
    public String resolveClassCastException(Model model, ClassCastException ex) {
        model.addAttribute("message", ex.getMessage());
        return "error";
    }

    // 与Controller一样, 可以通过@ResponseBody注解为前端返回json格式的数据
    @ExceptionHandler({ArrayIndexOutOfBoundsException.class, IndexOutOfBoundsException.class})
    @ResponseBody
    public Map<String, Object> resolveIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex) {
        return Collections.singletonMap("message", ex.getMessage());
    }

}
