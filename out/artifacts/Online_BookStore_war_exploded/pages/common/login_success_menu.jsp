<%--
  Created by IntelliJ IDEA.
  User: Suze
  Date: 1/9/2021
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <span>Welcome<span class="um_span">${sessionScope.user.username}</span>to Online Bookstore</span> ||
    <a href="pages/order/order.jsp">My Orders</a> ||
    <a href="userServlet?action=signout">Sign out</a>&nbsp;&nbsp;||
    <a href="index.jsp">Home</a>
</div>
