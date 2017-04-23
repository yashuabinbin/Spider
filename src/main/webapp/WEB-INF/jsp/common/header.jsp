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
    <link rel="stylesheet" type="text/css" href='<%=basePath%>css/global.css'/>
    <link rel="stylesheet" type="text/css" href='<%=basePath%>plugins/bootstrap/css/bootstrap.min.css'/>
    <script type="text/javascript" src='<%=basePath%>plugins/jquery-3.1.1.min.js'></script>
    <script type="text/javascript" src='<%=basePath%>plugins/bootstrap/js/tether.min.js'></script>
    <script type="text/javascript" src='<%=basePath%>plugins/bootstrap/js/bootstrap.min.js'></script>
    <script type="text/javascript" src='<%=basePath%>plugins/vue.js'></script>
    <script type="text/javascript" src='<%=basePath%>js/common/global.js'></script>
