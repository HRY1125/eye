<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2020/4/28
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>诊断请求列表</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/layui/css/layui.css">
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/layui/layui.js"  charset="utf-8"></script>
</head>
<body>
<div>
    <table class="layui-table" id="diagnose" lay-filter="diagnose"></table>


    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>

    <script type="text/html" id="toolbarDemo">
        <div class="layui-btn-container layui-inline">
            <button class="layui-btn layui-btn-sm" lay-event="insert">新增</button>
        </div>
    </script>
</div>

    <script type="text/javascript">
        layui.use('table', function() {
            var table = layui.table;//表格

            table.render({
                elem: '#diagnose'
                , height: $(document).height() - $('#diagnose').offset().top - 20
                , url: '<%=request.getContextPath()%>/diagnose/selectAll'
                , method: 'POST'
                , toolbar: '#toolbarDemo'
                , cols: [[
                    {field: 'diagnoseId', width: 100, title: '诊断ID', sort: true}
                    , {field: 'userId', width: 120, title: '请求诊断用户', sort: true}
                    , {field: 'doctorId', width:100,title: '章节名'}
                    , {field: 'diagnoseTitle', title: '诊断说明'}
                    , {field: 'date', width: 200, title: '请求时间',templet: '<div>{{ layui.util.toDateString(d.date,"yyyy-MM-dd HH:mm:ss") }}</div>'}
                    , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
                ]]
                , page: true
            });

        })
    </script>
</body>
</html>
