<%--
  Created by IntelliJ IDEA.
  User: kaiguan
  Date: 2020/5/6
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻动态管理</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/layui/css/layui.css" media="all">
    <script src="<%=request.getContextPath() %>/layui/layui.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
</head>
<body>
    <div class="layui-fluid">
        <table class="layui-table" id="newsManage" lay-filter="test"></table>
    </div>
    <div id="addForm" hidden="hidden" style="padding: 25px">
        <form action="<%=request.getContextPath() %>/adminNews/addNews" method="post" class="layui-form">
            <div class="layui-form-item">
                <label class="layui-form-label">新闻标题：</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" name="newsTitle" placeholder="请输入新闻标题" required><br>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">新闻内容：</label>
                <div class="layui-input-inline">
                    <textarea class="layui-textarea" name="newsContent" placeholder="开始撰写..." required lay-verify="required"></textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-inline layui-input-block">
                    <input type="submit" class="layui-btn" value="提交">
                    <input type="reset" class="layui-btn" value="重置">
                </div>
            </div>
        </form>
    </div>
    <div id="editForm" hidden="hidden" style="padding: 25px">
        <form action="<%=request.getContextPath() %>/adminNews/updateNews" method="post" class="layui-form">
            <input type="hidden" id="newsId" name="newsId">
            <input type="hidden" id="createTime1" name="createTime">
            <div class="layui-form-item">
                <label class="layui-form-label">新闻标题：</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" name="newsTitle" id="newsTitle" placeholder="请输入新闻标题" required><br>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">审核：</label>
                <div class="layui-input-inline">
                    <select name="approval" required id="approval">
                        <option value="">请选择审核状态</option>
                        <option value="0">审核中</option>
                        <option value="1">已审核</option>
                        <option value="2">审核未过</option>
                    </select><br>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-inline layui-input-block">
                    <input type="submit" class="layui-btn" value="确定">
                    <input type="reset" class="layui-btn" value="重置">
                </div>
            </div>
        </form>
    </div>
    <div id="textAreaForm" hidden="hidden" style="padding: 25px">
        <form action="<%=request.getContextPath() %>/adminNews/textAreaUpdate" method="post" class="layui-form">
            <input type="hidden" id="textAreaNewsId" name="newsId">
            <input type="hidden" id="createTime2" name="createTime">
            <div class="layui-form-item">
                <textarea class="layui-textarea" id="textAreaNewsContent" style="display: none" name="newsContent" placeholder="开始撰写..." required lay-verify="required"></textarea>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block" style="margin-left: 195px">
                    <input type="submit" class="layui-btn" value="保存">
                    <%--<input type="reset" class="layui-btn" value="重置">--%>
                </div>
            </div>
        </form>
    </div>
    <script>
        layui.use(['layer', 'table', 'form'], function () {
            var table = layui.table;
            var layer = layui.layer;
            var form = layui.form;
            var $ = layui.$;
            table.render({
                elem : '#newsManage',
                url : '<%=request.getContextPath() %>/adminNews/newsManage',
                page : true,
                height : 530,
                cols : [ [
                    {field : 'newsId',title : '新闻ID',align : 'center',width : 180,sort : true},
                    {field : 'newsTitle',title : '新闻标题',align : 'center',width : 200},
                    {title : '新闻内容',align : 'center',width : 180,
                        toolbar :
                            '<div>' +
                            '<a class="layui-btn" lay-event="lookEdit">查看 / 编辑</a>' +
                            '</div>'
                    },
                    {field: 'approval', title: '审核', width: 180,align:'center',templet:function (d) {
                            if(d.approval == '0') return '审核中';
                            else if (d.approval == '1') return '已审核';
                            else if(d.approval == '2') return '审核未过';
                    }},
                    {field : 'createTime',title : '发布时间',align : 'center',width : 180},
                    {fixed : 'right',title : '操作',width : 200,align : 'center',
                        toolbar :
                            '<div class="layui-btn-group">' +
                            '<a class="layui-btn" lay-event="edit">编辑</a>' +
                            '<a class="layui-btn layui-btn-danger" lay-event="del">删除</a>' +
                            '</div>'
                    }
                ] ],
                limits : [5, 10, 15],
                toolbar :
                    '<div class="layui-btn-group" style="padding: 15px;">' +
                    '<button class="layui-btn" lay-event="add">新增</button>' +
                    '</div>'
            });

            table.on('tool(test)', function (obj) {
                var data=obj.data;
                if(obj.event === 'del'){
                    layer.confirm('确定要删除吗', {
                        title:'删除',
                        anim : 6
                    }, function (index) {
                        obj.del();
                        $.ajax({
                            type : "POST",
                            url : "<%=request.getContextPath() %>/adminNews/deleteNews?newsId="+data.newsId,
                            success : function (msg) {
                                layer.alert(msg.msg);
                                layer.close(index);
                            }
                        });
                    });
                }else if (obj.event === 'edit'){
                    $("#newsId").val(data.newsId);
                    $("#newsTitle").val(data.newsTitle);
                    $("#newsContent").val(data.newsContent);
                    $("#approval").val(data.approval);
                    form.render();
                    layer.open({
                        type : 1,
                        title : '编辑新闻',
                        area : '420px',
                        moveType : 1,
                        resize : false,
                        anim : 2,
                        moveOut: true,
                        content : $('#editForm')
                    });
                }else if (obj.event === 'lookEdit'){
                    $("#textAreaNewsId").val(data.newsId);
                    $("#textAreaNewsContent").val(data.newsContent);
                    layer.open({
                        title : "编辑新闻内容",
                        type : 1,
                        area : '600px',
                        moveType : 1,
                        resize : false,
                        anim : 2,
                        moveOut: true,
                        content : $("#textAreaForm")
                    });
                }
            });

            table.on('toolbar(test)', function (obj) {
                if(obj.event === 'add'){
                    form.render();
                    layer.open({
                        type : 1,
                        title : '添加新闻',
                        area : '420px',
                        moveType : 1,
                        resize : false,
                        anim : 2,
                        moveOut: true,
                        content : $('#addForm')
                    });
                }
            });
        });

        layui.use('layedit', function(){
            var layedit = layui.layedit;
            layedit.build('textAreaNewsContent', {
                tool : ['strong','underline','|','left','center','right']
            });
        });

        layui.use('laydate',function(){
            var laydate=layui.laydate;
            laydate.render({
                elem: '#createTime1',
                type:'datetime',
                value: new Date()
            });
        });

        layui.use('laydate',function(){
            var laydate=layui.laydate;
            laydate.render({
                elem: '#createTime2',
                type:'datetime',
                value: new Date()
            });
        });
    </script>
</body>
</html>
