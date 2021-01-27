<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Suze BookStore Sign up </title>
    <!--	写base标签，永远固定相对路径跳转的结果-->
    <%@ include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {

            $("#username").blur(function () {

                //获取用户忙
                var username = this.value;

                $.getJSON("<%=basePath%>userServlet","action=ajaxExistsUsername&username="+username, function (data) {
                    if(data.existsUsername){
                        $("span.errorMsg").text("Username already exists!");
                    }else {
                        $("span.errorMsg").text("Username valid");
                    }
                });

            });

            $("#code_img").click(function () {
                // alert(1);
                this.src = "${basePath}kaptcha.jpg?d="+new Date();

            });

            $("#sub_btn").click(function () {
                var username = $("#username").val();
                var usernamePatt = /^\w{5,16}$/;
                if (!usernamePatt.test(username)) {
                    $(".errorMsg").text("Invalid Username");
                    return false;
                }

                var pwd = $("#password").val();
                var pwdPatt = /^\w{5,16}$/;
                if (!pwdPatt.test(pwd)) {
                    $(".errorMsg").text("Invalid Password!");
                    return false;
                }

                var repwd = $("#repwd").val();
                if (repwd !== pwd) {
                    $(".errorMsg").text("Those passwords didn't match!");
                    return false;
                }

                var email = $("#email").val();
                var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if (!emailPatt.test(email)) {
                    $(".errorMsg").text("Invalid Email!");
                    return false;
                }

                var codeText = $("#code").val();
                codeText = $.trim(codeText);
                if (codeText == null || codeText === "") {
                    $(".errorMsg").text("Invalid verification code");
                    return false;
                }

                $("span.errorMsg").text("");

            });




        });

    </script>
    <style type="text/css">
        .login_form {
            height: 420px;
            margin-top: 25px;
        }

    </style>
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
                    <h1>Sign Up</h1>
                    <span class="errorMsg">
                        <%--<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>--%>
                        ${requestScope.msg}
                    </span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="regist"/>
                        <label>Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <input class="itxt" type="text" placeholder="Please enter username" autocomplete="off" tabindex="1"
                               name="username" id="username"
<%--                               value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"/>--%>
                               value="${requestScope.username}"/>
                        <br/>
                        <br/>
                        <label>Password:</label>
                        <input class="itxt" type="password" placeholder="Please enter the password" autocomplete="off" tabindex="1"
                               name="password" id="password"/>
                        <br/>
                        <br/>
                        <label>Confirm:  &nbsp;</label>
                        <input class="itxt" type="password" placeholder="Re-enter the password" autocomplete="off" tabindex="1"
                               name="repwd" id="repwd"/>
                        <br/>
                        <br/>
                        <label>Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <input class="itxt" type="text" placeholder="Enter your email" autocomplete="off" tabindex="1"
                               name="email" id="email"
<%--                               value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"/>--%>
                               value="${requestScope.email}"/>
                        <br/>
                        <br/>
                        <label>Code:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                        <input class="itxt" type="text" style="width: 110px;" name="code" id="code"/>
                        <img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 50px; width: 100px; height: 30px"/>
                        <br/>
                        <br/>
                        <input type="submit" value="SIGN UP" id="sub_btn"/>

                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>