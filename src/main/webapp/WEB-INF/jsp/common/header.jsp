<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="taglibs.jsp" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href='<%=basePath%>css/global.css?version=${version}'/>
<link rel="stylesheet" type="text/css" href='<%=basePath%>plugins/bootstrap/css/bootstrap.min.css?version=${version}'/>
<script type="text/javascript" src='<%=basePath%>plugins/jquery-3.1.1.min.js?version=${version}'></script>
<script type="text/javascript" src='<%=basePath%>plugins/bootstrap/js/tether.min.js?version=${version}'></script>
<script type="text/javascript" src='<%=basePath%>plugins/bootstrap/js/bootstrap.min.js?version=${version}'></script>
<script type="text/javascript" src='<%=basePath%>plugins/vue.js?version=${version}'></script>
<script type="text/javascript" src='<%=basePath%>js/common/global.js?version=${version}'></script>
<script type="text/javascript">
    var basePath = '<%=basePath%>';
</script>
