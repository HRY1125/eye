<%--
  Created by IntelliJ IDEA.
  User: kaiguan
  Date: 2020/5/8
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>常见问题管理</title>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/layui/css/layui.css" media="all">
    <script src="<%=request.getContextPath() %>/layui/layui.js"></script>
    <script src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
</head>
<body>
    <div class="layui-fluid">
        <table class="layui-table" id="questionsManage" lay-filter="test"></table>
    </div>
    <div id="addForm" hidden="hidden" style="padding: 20px">
        <form action="<%=request.getContextPath() %>/adminQuestions/addQuestions" method="post" class="layui-form">
            <div class="layui-form-item">
                <label class="layui-form-label">问题标题：</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" name="questionTitle" placeholder="请输入问题标题" required>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">问题内容：</label>
                <div class="layui-input-inline">
                    <textarea class="layui-textarea" name="questionContent" placeholder="开始提问..." required></textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">问题回答：</label>
                <div class="layui-input-inline">
                    <textarea class="layui-textarea" name="questionAnswer" placeholder="开始回答..."></textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-inline layui-input-block">
                    <input type="submit" class="layui-btn" value="提交">
                    <input type="reset" class="layui-btn layui-btn-primary" value="重置">
                </div>
            </div>
        </form>
    </div>
    <div id="editContentForm" hidden="hidden" style="padding: 20px">
        <form action="<%=request.getContextPath() %>/adminQuestions/updateContent" method="post" class="layui-form">
            <input type="hidden" id="questionId1" name="questionId">
            <input type="hidden" id="createTime1" name="createTime">
            <div class="layui-form-item">
                <label class="layui-form-label">问题标题：</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" name="questionTitle" id="questionTitle" placeholder="请输入问题标题" required style="width: 420px">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">问题内容：</label>
                <div class="layui-input-inline">
                    <textarea id="questionContent" class="layui-textarea" name="questionContent" placeholder="开始提问..." required style="height: 200px;width: 420px"></textarea>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block" style="margin-left: 210px">
                    <input type="submit" class="layui-btn" value="提交">
                    <input type="reset" class="layui-btn layui-btn-primary" value="重置">
                </div>
            </div>
        </form>
    </div>
    <div id="editAnswerForm" hidden="hidden" style="padding: 20px">
        <form action="<%=request.getContextPath() %>/adminQuestions/updateAnswer" method="post" class="layui-form">
            <input type="hidden" id="questionId2" name="questionId">
            <input type="hidden" id="createTime2" name="createTime">
            <div class="layui-form-item">
                <textarea id="questionAnswer" class="layui-textarea" name="questionAnswer" placeholder="开始回答..." required style="height: 200px"></textarea>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block" style="margin-left: 210px">
                    <input type="submit" class="layui-btn" value="提交">
                    <input type="reset" class="layui-btn layui-btn-primary" value="重置">
                </div>
            </div>
        </form>
    </div>
    <script type="text/javascript">
        layui.use(['layer', 'table', 'form'], function () {
            var table = layui.table;
            var layer = layui.layer;
            var form = layui.form;
            var $ = layui.$;
            table.render({
                elem : '#questionsManage',
                url : '<%=request.getContextPath() %>/adminQuestions/questionsManage',
                page : true,
                height : 530,
                cols : [ [
                    {field : 'questionId',title : '问题ID',align : 'center',width : 185,sort : true},
                    {field : 'questionTitle',title : '问题标题',align : 'center',width : 195},
                    {title : '问题内容',align : 'center',width : 185,
                        toolbar :
                            '<div>' +
                            '<a class="layui-btn layui-btn-sm" lay-event="lookEditContent">查看 / 编辑</a>' +
                            '</div>'
                    },
                    {title : '问题回答',align : 'center',width : 185,
                        toolbar :
                            '<div>' +
                            '<a class="layui-btn layui-btn-sm" lay-event="lookEditAnswer">查看 / 编辑</a>' +
                            '</div>'
                    },
                    {field : 'createTime',title : '发布时间',align : 'center',width : 185},
                    {fixed : 'right',title : '操作',width : 195,align : 'center',
                        toolbar :
                            '<div class="layui-btn-group">' +
                            '<a class="layui-btn layui-btn-sm layui-btn-danger" lay-event="del">删除</a>' +
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
                            url : "<%=request.getContextPath() %>/adminQuestions/deleteQuestions?questionId="+data.questionId,
                            success : function (msg) {
                                layer.alert(msg.msg);
                                layer.close(index);
                            }
                        });
                    });
                }else if (obj.event === 'lookEditContent'){
                    $("#questionId1").val(data.questionId);
                    $("#questionTitle").val(data.questionTitle);
                    $("#questionContent").val(data.questionContent);
                    form.render();
                    layer.open({
                        title : "编辑问题内容",
                        type : 1,
                        area : '600px',
                        moveType : 1,
                        resize : false,
                        anim : 2,
                        moveOut: true,
                        content : $("#editContentForm")
                    });
                }else if (obj.event === 'lookEditAnswer'){
                    $("#questionId2").val(data.questionId);
                    $("#questionAnswer").val(data.questionAnswer);
                    layer.open({
                        title : "编辑问题回答",
                        type : 1,
                        area : '600px',
                        moveType : 1,
                        resize : false,
                        anim : 2,
                        moveOut: true,
                        content : $("#editAnswerForm")
                    });
                }
            });

            table.on('toolbar(test)', function (obj) {
                if(obj.event === 'add'){
                    form.render();
                    layer.open({
                        type : 1,
                        title : '添加问题',
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
