<%--
  Created by IntelliJ IDEA.
  User: beark
  Date: 1/9/2021
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="http://localhost:8080/09_EL_JSTL/uploadServlet" method="post" enctype="multipart/form-data">

        用户名：<input type="text" name="username"/><br>
        头像：<input type="file" name="photo"><br>
        <input type="submit" value="submit">

    </form>
</body>
</html>
