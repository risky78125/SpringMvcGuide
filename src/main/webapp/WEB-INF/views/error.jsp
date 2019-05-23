<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Risky
  Date: 2019/5/23
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>出错了</title>
</head>
<body>
<h1>错误页面</h1>
<p>${message}</p>
<c:forEach var="error" items="${errors}">
    <p>${error.defaultMessage}</p>
</c:forEach>
</body>
</html>
