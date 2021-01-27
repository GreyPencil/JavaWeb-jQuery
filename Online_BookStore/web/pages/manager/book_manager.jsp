<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Management</title>
    <%@ include file="/pages/common/head.jsp" %>
    <script type="text/javascript">

        $(function () {

            $("a.deleteClass").click(function () {
                return confirm("Delete [" + $(this).parent().parent().find("td:first-child").text() + "]?")
            });

            $("#searchPageBtn").click(function () {

                var pageNo = $("#pn_input").val();
                var pageTotal = ${requestScope.page.pageTotal};

                if (pageNo < 1 || pageNo > pageTotal) {
                    alert("Oh no no!");
                } else {


                    location.href = "${pageScope.basePath}manager/bookServlet?action=page&pageNo=" + pageNo;
                }


            });


        });

    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.png">
    <span class="wel_word">Book Management System</span>
    <%@ include file="/pages/common/manager_menu.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>Name</td>
            <td>Price</td>
            <td>Author</td>
            <td>Sales</td>
            <td>Stock</td>
            <td colspan="2">Operation</td>
        </tr>

        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">Edit</a></td>
                <td><a class="deleteClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">Delete</a></td>
            </tr>
        </c:forEach>


        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?pageNo=${requestScope.page.pageTotal}">Add Book</a></td>
        </tr>
    </table>

    <%@include file="/pages/common/page_nav.jsp" %>

</div>

<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>