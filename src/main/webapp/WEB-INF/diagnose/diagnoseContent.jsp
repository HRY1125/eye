<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2020/4/30
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>诊断内容</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/diagnose/diagnoseContent.css" type="text/css">
    <%--引入wangEditor富文本编辑器--%>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/wangEditor.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/diagnoseContent.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css" type="text/css">
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <script src="<%=request.getContextPath()%>/js/echarts.min.js"></script>
</head>
<body>
    <div id="mainDiagnose">
        <span id="diagnoseId" style="display: none">${diagnoseId}</span>
        <div id="chart">
            <div id="line_chart"></div>
            <div id="bar_chart"></div>
            <div id="pie_chart"></div>
        </div>
        <div id="diagnoseContent"></div>
        <div id="report">
            <div id="user_content">
                <c:if test="${userName != null}">
                    <div class="user" id="user_id">
                        <span>用户</span>
                        <span>${userName}</span>
                    </div>
                </c:if>
                <c:if test="${doctorName != null}">
                    <div class="user" id="docter_id">
                        <span>医生</span>
                        <span>${doctorName}</span>
                    </div>
                </c:if>
            </div>
            <div id="dC_report_editor">
                <%--            <div id="toolbar_div" class="toolbar"></div>--%>
                <%--            <div id="text_div" class="text"></div>--%>
                <div id="editor"></div>
                <div id="btn_div">
                    <button type="button" id="btn_submit">回复</button>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
