<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="common/header.jsp" %>
    <title>forgetPwd</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css?version=${version}"/>
</head>

<body class="loginBody">
<div class="container">
    <div class="top">
    </div>
    <div class="row pwdContainer">
        <div class="col-md-offset-4 col-md-5 loginBox">
            <form id="loginForm">
                <div class="text-center loginTop">
                    FORGET PASSWORD
                </div>
                <div class="loginMiddle">
                    <div class="input-group input-group-lg mt20">
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-envelope"></span>
                        </span>
                        <input type="text" class="form-control" v-model="email" placeholder="email...">
                    </div>
                </div>
                <div class="loginBottom text-center">
                    <button type="button" class="btn btn-default btn-block btn-large cBtn" v-on:click="sendEmail($event)">Send</button>
                </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp" %>
<script type="text/javascript" src="<%=basePath%>js/pwd.js?version=${version}"></script>
</body>
</html>