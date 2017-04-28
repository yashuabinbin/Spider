<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="common/header.jsp" %>
    <title>注册页面</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css?version=${version}"/>
</head>
<body class="loginBody">
<div class="container">
    <div class="top">
    </div>
    <div class="row registerContainer">
        <div class="col-md-offset-4 col-md-5 loginBox">

            <%--注册表单验证--%>
            <form id="registerForm" novalidate>
                <div class="text-center loginTop">
                    REGISTER
                </div>
                <div class="registerMiddle">

                    <%--用户名--%>
                    <div v-bind:class="{'has-error':invalid.username}">
                        <input type="text" id="username" name="username" class="form-control" v-model="username" placeholder="username"/>
                    </div>

                    <%--姓名--%>
                    <div v-bind:class="{'has-error':invalid.realname}">
                        <input type="text" id="realname" name="realname" class="form-control" v-model="realname" placeholder="realname"/>
                    </div>

                    <%--邮箱--%>
                    <div v-bind:class="{'has-error':invalid.email}">
                        <input type="text" id="email" name="email" class="form-control" v-model="email" placeholder="email"/>
                    </div>

                    <%--密码--%>
                    <div v-bind:class="{'has-error':invalid.password}">
                        <input type="password" id="password" name="password" class="form-control" v-model="password" placeholder="password"/>
                    </div>
                </div>
                <div class="loginBottom text-center">
                    <button type="button" class="btn btn-default btn-block btn-large" id="registerBtn" v-on:click="registerSubmit">REGISTER
                    </button>
                    <div class="link">
                        Already Has An Account ? <a href="<%=basePath%>login">Login</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%@ include file="common/footer.jsp" %>
<script type="text/javascript" src="<%=basePath%>js/register.js"></script>
</body>
</html>
