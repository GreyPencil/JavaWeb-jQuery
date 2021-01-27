<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit book</title>
	<%@ include file="/pages/common/head.jsp" %>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color: #ff0000;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.png" >
			<span class="wel_word">Edit Books</span>
		<%@ include file="/pages/common/manager_menu.jsp" %>
		</div>
		
		<div id="main">
			<form action="manager/bookServlet" method="get"/>
			<input type="hidden" name="action" value="${empty param.id ? "add":"update"}"/>
			<input type="hidden" name="pageNo" value="${param.pageNo}"/>
			<input type="hidden" name="id" value="${requestScope.book.id}"/>
				<table>
					<tr>
						<td>Name</td>
						<td>Price</td>
						<td>Author</td>
						<td>Sales</td>
						<td>Stock</td>
						<td colspan="2">Edit</td>
					</tr>		
					<tr>
						<td><input name="name" type="text" value="${requestScope.book.name}"/></td>
						<td><input name="price" type="text" value="${requestScope.book.price}"/></td>
						<td><input name="author" type="text" value="${requestScope.book.author}"/></td>
						<td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
						<td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
						<td><input type="submit" value="Submit"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>
		
		<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>