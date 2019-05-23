<%--
  Created by IntelliJ IDEA.
  User: Risky
  Date: 2019/5/23
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据校验</title>
</head>
<body>

<h1>登录测试</h1>
<form action="/validate/login" method="post">

    <label>用户名: <input type="text" name="username"></label> <br>
    <label>密码: <input type="text" name="password"></label> <br>
    <input type="submit" value="登录">

</form>
<hr>
<h1>注册测试</h1>
<form action="/validate/register" method="post">
    <label>用户名: <input type="text" name="username"></label> <br>
    <label>密码: <input type="text" name="password"></label> <br>
    <label>手机号: <input type="text" name="mobile"></label> <br>
    <label>邮箱: <input type="text" name="email"></label> <br>
    <label>生日: <input type="date" name="birthday"></label> <br>
    <label>请同意协议: <input type="checkbox" name="agree" value="true"></label> <br>
    <input type="submit" value="登录">
</form>

</body>
</html>
