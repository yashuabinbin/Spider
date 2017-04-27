<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="common/header.jsp" %>
    <title>注册页面</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css?version=${version}"/>
</head>
<body>
<body class="loginBody">
<div class="container">
    <div class="top">
    </div>
    <div class="row loginContainer">
        <div class="col-md-offset-4 col-md-5 loginBox">
            <form id="loginForm">
                <div class="text-center loginTop">
                    REGISTER
                </div>
                <div class="registerMiddle">

                    <%--用户名--%>
                    <input type="text" id="username" class="form-control" style="margin-top:0px;" v-model="username"
                           placeholder="username">

                    <%--真名--%>
                    <input type="text" id="realname" class="form-control" v-model="realname" placeholder="realname">

                    <%--邮箱--%>
                    <input type="text" id="email" class="form-control" v-model="email" placeholder="email">

                    <%--密码--%>
                    <input type="password" id="password" class="form-control" v-model="password" placeholder="password">

                </div>
                <div class="loginBottom text-center">
                    <button type="button" class="btn btn-default btn-block btn-large" id="loginBtn"
                            v-on:click="loginSubmit">REGISTER
                    </button>
                    <div class="register">
                        Already Has An Account ? <a href="<%=basePath%>login">Login</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%@ include file="common/footer.jsp" %>
</body>
</html>
