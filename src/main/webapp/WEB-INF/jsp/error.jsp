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
            <div class="text-center loginTop">
                ${errorMsg}
            </div>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp" %>
</body>
</html>