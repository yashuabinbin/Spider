<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="common/header.jsp" %>
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css?version=${version}"/>
</head>

<body>
<div class="container">
    <div class="top">
    </div>
    <div class="row loginContainer">
        <div class="col-md-offset-4 col-md-4 loginBox">
            <form id="loginForm">
                <div class="text-center loginTop">
                    用 户 登 陆
                </div>
                <div class="loginMiddle">
                    <div class="input-group">
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-user"></span>
                        </span>
                        <input type="text" class="form-control" v-model="username" v-on:keyup.enter="loginSubmit"
                               placeholder="username...">
                    </div>

                    <div class="input-group mt30">
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-lock"></span>
                        </span>
                        <input type="password" class="form-control" v-model="password" v-on:keyup.enter="loginSubmit"
                               placeholder="password...">
                    </div>
                </div>
                <div class="loginBottom text-center">
                    <button type="button" class="btn btn-default" v-on:click="loginSubmit">登　录</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp" %>
<script type="text/javascript" src="<%=basePath%>js/login.js?version=${version}"></script>
</body>
</html>