<%--
  Created by IntelliJ IDEA.
  User: beark
  Date: 1/8/2021
  Time: 7:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("key", "value");
%>
表达式脚本输出key的值是：<%= request.getAttribute("key")%>
EL表达式输出key的值是：${key}
</body>
</html>
