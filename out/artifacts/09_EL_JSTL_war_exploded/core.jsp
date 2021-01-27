<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: beark
  Date: 1/9/2021
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <c:forEach end=""></c:forEach>--%>
${requestScope.abc}<br>
<c:set scope="request" var="abc" value="abcValue"/>
${requestScope.abc}<br>
<hr>

<c:if test="${12==12}">
    <h1>12=12</h1>
</c:if>
<hr>
<c:if test="${12!=12}">
    <h1>12!=12</h1>
</c:if>

<hr>

<c:forEach begin="1" end="10" var="i">
    ${ i }
</c:forEach>
<hr>
<%
    request.setAttribute("arr", new String[]{"123","234","325"});

%>

<c:forEach items="${requestScope.arr}" var="item">
    ${ item }<br>
</c:forEach>
</body>
</html>
