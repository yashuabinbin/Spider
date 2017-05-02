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
            <form id="registerForm">
                <div class="text-center loginTop">
                    REGISTER
                </div>
                <div class="registerMiddle">

                    <%--用户名--%>
                    <div v-bind:class="{'has-error':invalid.username.val}">
                        <input type="text" id="username" name="username" class="form-control" v-model="username"
                               placeholder="username"/>
                    </div>

                    <%--姓名--%>
                    <div v-bind:class="{'has-error':invalid.realname.val}">
                        <input type="text" id="realname" name="realname" class="form-control" v-model="realname"
                               placeholder="realname"/>
                    </div>

                    <%--邮箱--%>
                    <div v-bind:class="{'has-error':invalid.email.val}">
                        <input type="text" id="email" name="email" class="form-control" v-model="email"
                               placeholder="email"/>
                    </div>

                    <%--密码--%>
                    <div class="input-group" v-bind:class="{'has-error':invalid.password.val}">
                        <input type="password" id="password" name="password" class="form-control" v-model="password"
                               placeholder="password"/>
                        <span class="input-group-addon crp" v-on:click="showPwd">
                            <span class="glyphicon" v-bind:class="eye"></span>
                        </span>
                    </div>

                        <%--性别--%>
                        <div class="row sexDiv">
                        <span class="col-md-3">
                            <input type="radio" class="ml5" name="sex" v-model="sex" value="1"> Male
                        </span>
                        <span class="col-md-9">
                            <input type="radio" name="sex" v-model="sex" value="0"> Female
                        </span>
                        </div>
                </div>
                <div class="loginBottom text-center">
                    <button type="button" class="btn btn-default btn-block btn-large cBtn" id="registerBtn"
                            v-on:click="registerSubmit">REGISTER
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
