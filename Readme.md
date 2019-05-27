# SpringMVC的相关用法

## 主要内容

1. `@RequestMapping`注解中相关参数的意义

    参考`RequestMappingController`类.
    
2. Controller中方法的参数可以定义的类型统计

    普通常用的基本参数没有写, 介绍了一些稍微冷门但是还有点用的, 参考`ParameterController`类
    
3. 返回json数据时, 返回相同的对象但是json字段不同

    参考`JsonController`和`BookInfo`类
    
4. 捕获Controller中的异常

    参考`ExceptionController`和`ExceptionAdvice`类
    
5. 增加数据校验和分组校验

    参考`ValidationController`,`UserInfo`, `ExceptionAdvice`
    
6. 路径参数集合正则表达式获取数据

    参考`PathController`

7. 在重定向的请求直接传递数据

    参考`RedirectController`
    
8. 为请求设置不同的响应码

    参考`ExceptionAdvice`中的`@ResponseStatus`注解