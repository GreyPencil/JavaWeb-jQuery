<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Log in</title>
    <%@ include file="/pages/common/head.jsp" %>

</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="static/img/logo.png">
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">Welcome!</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>Membership</h1>

                    <a href="pages/user/regist.jsp">Sign up</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">
<%--                        <%=request.getAttribute("msg") == null ? "Enter username and password" : request.getAttribute("msg")%>--%>
                        ${ empty requestScope.msg? "Enter username and password" : requestScope.msg}
                        </span>
                </div>
                <div class="form">

                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="login" />
                        <label>Username:</label>
                        <input class="itxt" type="text" placeholder="Please enter username"
                               autocomplete="off" tabindex="1" name="username"
<%--                           value = "<%=request.getAttribute("username")==null? "":request.getAttribute("username")%>"--%>
                                value = "${requestScope.username}"
                        />
                        <br/>
                        <br/>
                        <label>Password:</label>
                        <input class="itxt" type="password" placeholder="Please enter password" autocomplete="off" tabindex="1"
                               name="password"/>
                        <br/>
                        <br/>
                        <input type="submit" value="Log in" id="sub_btn"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>