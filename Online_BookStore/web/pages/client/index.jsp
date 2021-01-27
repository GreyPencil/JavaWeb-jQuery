<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <%@ include file="/pages/common/head.jsp" %>

    <script type="text/javascript">

        $(function () {
            $("button.addToCart").click(function () {

                var bookId = $(this).attr("bookId");

                // location.href = "http://localhost:8080/Online_BookStore/cartServlet?action=addItem&id=" + bookId;

                $.getJSON("http://localhost:8080/Online_BookStore/cartServlet", "action=ajaxAddItem&id=" + bookId, function (data) {
                    $(".cartTotalCount").text("Cart Subtotal " + data.totalCount + "items");
                    $(".cartLastName").text(data.lastName);

                });
            });
        });


    </script>

    <style>
        #search {
            width: 60px;
        }
    </style>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.png">
    <span class="wel_word"> &nbsp; Online Bookstore</span>
    <div>
        <%--				如果没有登录， 显示登录和注册信息--%>
        <c:if test="${empty sessionScope.user}">
            <a href="pages/user/login.jsp">Login</a> ||
            <a href="pages/user/regist.jsp">Sign up</a> &nbsp;&nbsp; ||
        </c:if>
        <c:if test="${not empty sessionScope.user}">
            <span>Welcome<span class="um_span">${sessionScope.user.username}</span>to Online Bookstore ||</span>
            <a href="pages/order/order.jsp">My Orders</a> ||
            <a href="userServlet?action=signout">Sign out</a>&nbsp;&nbsp;||
        </c:if>

        <a href="pages/cart/cart.jsp">Shopping Cart</a> ||
        <a href="pages/manager/manager.jsp">Management</a>
    </div>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            <form action="client/bookServlet" method="get">
                <input type="hidden" name="action" value="pageByPrice"/>
                PRICE: CDN$ <input id="min" type="text" name="min" value="${param.min}"> -
                CDN$ <input id="max" type="text" name="max" value="${param.max}">
                <input id="search" type="submit" value="Search"/>
            </form>
        </div>
        <div style="text-align: center">
            <%--            //购物车为空--%>
            <c:if test="${empty sessionScope.cart.items}">
                <span class="cartTotalCount"></span>
                <div>
                    <span style="color: red" class="cartLastName">Your shopping cart is empty!</span>
                </div>
            </c:if>
            <%--            购物车非空--%>
            <c:if test="${not empty sessionScope.cart.items}">
                <span class="cartTotalCount">Cart Subtotal (${sessionScope.cart.totalCount} items)</span>
                <div>
                    <span style="color: red" class="cartLastName">【 ${sessionScope.lastName}】 </span>Added to cart!
                </div>
            </c:if>

        </div>

        <c:forEach items="${requestScope.page.items}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.imgPath}"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">Name:</span>
                        <span class="sp2">${book.name}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">Author: </span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">Price: </span>
                        <span class="sp2">$${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">Sales:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">Stocks:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button bookId="${book.id}" class="addToCart">Add to cart</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>


    <%--		静态包含分页条--%>
    <%@include file="/pages/common/page_nav.jsp" %>

</div>

<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>