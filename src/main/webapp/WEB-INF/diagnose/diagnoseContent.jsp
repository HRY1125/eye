<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2020/4/30
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>诊断内容</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <%--引入wangEditor富文本编辑器--%>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/wangEditor.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/diagnoseContent.js"></script>
</head>
<body>
    <span id="diagnoseId" style="display: none">${diagnoseId}</span>
    <div id="chart">

    </div>
    <div id="diagnoseCOntent"></div>
    <div id="report">
        <div class="editor_title">
            <div id="editor_title_span">
                <span>提问题</span>
            </div>
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
</body>
</html>
