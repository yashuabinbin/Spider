<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="taglibs.jsp"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href='<%=basePath%>css/common/global.css'/>
    <link rel="stylesheet" type="text/css" href='<%=basePath%>plugins/bootstrap/css/bootstrap.css'/>
    <script type="text/javascript" src='<%=basePath%>plugins/bootstrap/js/bootstrap.js'></script>
    <script type="text/javascript" src='<%=basePath%>plugins/vue.js'></script>
    <script type="text/javascript" src='<%=basePath%>js/common/global.js'></script>
