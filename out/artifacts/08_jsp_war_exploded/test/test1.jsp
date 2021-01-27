<%--
  Created by IntelliJ IDEA.
  User: beark
  Date: 1/8/2021
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <%
        for (int i = 1; i < 10; i++) {
            for(int j =1; j<=i; j++){
                %>
            <%=j +"x" + i +"=" + (i*j)%>


    <%
            }
            %>
        <br/>
    <%
        }
    %>
</table>
</body>
</html>
