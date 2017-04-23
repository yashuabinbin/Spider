<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/header.jsp" %>
<title>login</title>
</head>
<body>
<div class="container">
    <form id="loginForm">
        <input type="text" v-model="username" placeholder="please input username"/>
        <input type="password" v-model="password" placeholder="please input password"/>
        <input type="button" class="loginBtn" value="login" v-on:click="loginSubmit"/>
    </form>
</div>
</body>

<script type="text/javascript">
    var ve = new Vue({
        el: '#loginForm',
        data: {},
        methods: {
            loginSubmit: function () {
                alert("login submit");
            }
        }
    });
</script>
</html>