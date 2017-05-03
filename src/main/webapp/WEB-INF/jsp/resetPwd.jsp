<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="common/header.jsp" %>
    <title>resetPwd</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css?version=${version}"/>
</head>

<body class="commonBody">
<div class="container">
    <div class="top">
    </div>
    <div class="row pwdContainer">
        <div class="col-md-offset-4 col-md-5 commonBox">
            <div class="text-center commonTop">
                RESET PASSWORD
            </div>
            <div class="commonMiddle">
                <div v-bind:class="{'has-error':invalid.password.val}">
                    <input type="password" class="form-control" id="password" v-model="password" placeholder="new password...">
                </div>
                <div class="mt20" v-bind:class="{'has-error':invalid.confirmPassword.val}">
                    <input type="password" class="form-control" id="confirmPassword" v-model="confirmPassword" placeholder="confirm new password...">
                </div>
            </div>
            <div class="commonBottom shortBottom text-center">
                <button type="button" class="btn btn-default btn-block btn-large cBtn" v-on:click="resetPassword">Reset</button>
            </div>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp" %>
<script type="text/javascript" src="<%=basePath%>js/resetPwd.js?version=${version}"></script>
</body>
</html>