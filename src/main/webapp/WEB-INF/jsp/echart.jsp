<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <%@ include file="common/header.jsp" %>
    <script type="text/javascript" src="<%=basePath%>plugins/echarts.min.js?version=${version}"></script>
</head>
<body>

<div id="chartDiv">
    <div id="chart1" style="width: 600px;height:400px;"></div>
    <button v-on:click="showChart1">chart1</button>

    <br/>
    <br/>

    <div id="chart2" style="width: 600px;height:400px;"></div>
</div>
<%@ include file="common/footer.jsp" %>
<script type="text/javascript" src="<%=basePath%>js/echart/echart.js?version=${version}"></script>
</body>
</html>
