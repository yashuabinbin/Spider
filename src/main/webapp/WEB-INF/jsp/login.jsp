<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/header.jsp" %>
<title>login</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/login.css"/>
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
</body>

<script type="text/javascript">
    var ve = new Vue({
        el: '.loginContainer',
        data: {
            username: '',
            password: ''
        },
        methods: {
            loginSubmit: function () {
                alert("login submit");
            }
        }
    });
</script>
</html>