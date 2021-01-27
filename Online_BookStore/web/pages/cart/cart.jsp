<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shopping Cart</title>
    <%@ include file="/pages/common/head.jsp" %>
    <script>
        $(function () {
            $("a.deleteItems").click(function () {
                return confirm("Are your sure to delete 【"+$(this).parent().parent().find("td:first").text()+"】?")
            });

            $("a.clearCart").click(function () {
                return confirm("Are your sure to delete all items?")
            });

            $(".updateCount").change(function () {

                var name = $(this).parent().parent().find("td:first").text();
                //转成jquery对象
                var id = $(this).attr('bookId');
                var count = this.value;

                if(confirm("Are your sure to add 【"+ name +"】 to 【"+ count +"】 ?")){
                    location.href = "<%=basePath%>cartServlet?action=updateCount&count="+count+"&id="+id;
                }else {
                    this.value = this.defaultValue;
                }
            });

        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.png">
    <span class="wel_word">Cart</span>

    <%@ include file="/pages/common/login_success_menu.jsp" %>
</div>

<div id="main">
<%--    <%=basePath%>--%>
    <table>
        <tr>
            <td>Book Name</td>
            <td>Quantity</td>
            <td>Price</td>
            <td>Total Price</td>
            <td>Operation</td>
        </tr>
        <c:if test="${empty sessionScope.cart.items}">

            <tr>
                <td colspan="5">
                    <a href="index.jsp">Your Shopping Cart is Empty! Let's go shopping!</a>
                </td>
            </tr>


        </c:if>

        <c:if test="${not empty sessionScope.cart.items}">

            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td>
                        <input class="updateCount" type="text"
                               bookId="${entry.value.id}"
                               value="${entry.value.count}" style="width: 60px"/>
                    </td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a class="deleteItems" href="cartServlet?action=deleteItem&id=${entry.value.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">Subtotal:<span class="b_count">${sessionScope.cart.totalCount}</span>Items</span>
            <span class="cart_span">Total Price: CDN$<span class="b_price">${sessionScope.cart.totalPrice}</span></span>
            <span class="cart_span"><a class="clearCart" href="cartServlet?action=clearCart">Delete all items</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">Proceed to Checkout</a></span>
        </div>
    </c:if>
</div>

<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>