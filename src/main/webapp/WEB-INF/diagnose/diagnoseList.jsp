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
        <a class="layui-btn layui-btn-xs" lay-event="edit">查看具体信息</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
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
                    , {field: 'userName', width: 120, title: '请求诊断用户',templet: function (d) {
                            return getUserName(d.userId);
                        }}
                    , {field: 'doctorName', width:100,title: '医生姓名',templet: function (d) {
                            return getDoctorName(d.doctorId);
                        }}
                    , {field: 'diagnoseTitle', title: '诊断说明'}
                    , {field: 'date', width: 200, title: '请求时间',templet: '<div>{{ layui.util.toDateString(d.date,"yyyy-MM-dd HH:mm:ss") }}</div>'}
                    , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 180}
                ]]
                , page: true
            });

            function getUserName(userId){
                var userName;
                $.ajax({
                    type:"POST",
                    url:"<%=request.getContextPath()%>/diagnose/selectByUserId",
                    async:false,
                    data:{"userId":userId},
                    dataType: "json",
                    success:function (data) {
                        userName = data.userName;
                    }
                });
                return userName;
            }

            function getDoctorName(doctorId){
                var doctorName;
                $.ajax({
                    type:"POST",
                    url:"<%=request.getContextPath()%>/diagnose/selectByDoctorId",
                    async:false,
                    data:{"doctorId":doctorId},
                    dataType: "json",
                    success:function (data) {
                        doctorName = data.doctorName;
                    }
                });
                return doctorName;
            }


            //监听行工具事件
            table.on('tool(diagnose)', function(obj){
                var data = obj.data;
                if(obj.event === 'del'){
                    layer.confirm('真的删除行么', function(index){
                        $.ajax({
                            type : "POST",
                            async: false,
                            url :"<%=request.getContextPath()%>/diagnose/deleteDiagnose",
                            contentType: "application/json;charset=UTF-8",
                            data: JSON.stringify(data),
                            success: function (result) {
                                layer.msg(result.msg);
                                table.reload('diagnose',{
                                    url: '<%=request.getContextPath()%>/diagnose/selectAll',
                                    height: $(document).height()-$('#diagnose').offset().top-20,
                                    method: 'POST',
                                    toolbar: '#toolbarDemo',
                                    page:{
                                        curr:1
                                    }
                                });
                            }
                        });
                    });
                } else if(obj.event === 'edit') {
                    $.ajax({
                        type:"POST",
                        url:"<%=request.getContextPath()%>/dContent/edit",
                        data:{"diagnoseId":data.diagnoseId},
                        dataType:"json",
                        success:function (result) {
                            window.location.href = "/dContent/toDiagnoseContent?diagnoseId="+result.diagnoseId;
                        }
                    });
                }
            });

        })
    </script>
</body>
</html>
