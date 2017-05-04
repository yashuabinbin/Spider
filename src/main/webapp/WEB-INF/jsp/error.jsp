<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="common/header.jsp" %>
    <title>forgetPwd</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css?version=${version}"/>
</head>

<body class="commonBody">
<div class="container">
    <div class="top">
    </div>
    <div class="row">
        <div class="col-md-offset-4 col-md-5 commonBox">
            <div class="text-center commonTop">
                ${errorMsg}
            </div>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp" %>
</body>
</html>