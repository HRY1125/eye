<%--
  Created by IntelliJ IDEA.
  User: 张照伟
  Date: 2020/4/30
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/layui/css/layui.css">
    <script src="<%=request.getContextPath()%>/layui/layui.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <style type="text/css">
        #demo{
            height: 100%;
            width: 100%;
            margin: 0;
            padding: 0;
        }
        .search {
            float: right;
            width: 450px;
        }

        .hint {
            width: auto;
        }

        #condition{
            width: 180px;
        }

        .form{
            margin-top: 20px;
        }
    </style>
</head>
<body>
<input type="hidden" value="${msg}" id="msg">
<div id="addForm" hidden="hidden">
    <form action="<%=request.getContextPath()%>/goods/insert" class="form layui-form" method="post" enctype="multipart/form-data">
        <%--商品名称--%>
        <div class="layui-form-item" style="margin-top: 2vw;">
            <label class="layui-form-label">商品名称</label>
            <div class="layui-input-block">
                <input type="text" name="g_name" placeholder="请输入商品名称(不能包含空格数字)" autocomplete="off" class="layui-input"
                       onkeyup="value=value.replace(/[\d]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[\d]/g,''))"
                       maxlength="15">
            </div>
        </div>

        <%--商品生产日期--%>
        <div class="layui-form-item"  style="margin-top: 2vw;">
            <div class="layui-inline">
                <label class="layui-form-label">生产日期</label>
                <div class="layui-input-block">
                    <input type="text" name="g_date" id="g_date1" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <%--商品图片--%>
            <div class="layui-form-item" style="margin-top: 2vw;">
                <label class="layui-form-label">商家图片：</label>
                <div class="layui-upload">
                    <button type="button" class="layui-btn" id="test1">上传图片</button>
                    <input type="hidden" id="img_url1" name="g_url"/>
                    <div class="layui-upload-list">
                        <img class="layui-upload-img" name="g_url">
                        <p id="demoText1"></p>
                    </div>
                </div>
            </div>
        <%--<div class="layui-form-item">
            <label class="layui-form-label">商品图片</label>
            <div class="layui-input-block">
                <input type="text" name="g_url" autocomplete="off" class="layui-input">
            </div>
        </div>--%>
        <%--<div class="layui-form-item layui-upload">
            <label class="layui-form-label">商品图片</label>
            <div class="layui-input-block">
                &lt;%&ndash;图片上传：<input type="file" name="g_url" autocomplete="off" class="layui-input">
                <input type="submit" value="提交">&ndash;%&gt;
                <button type="button" class="layui-btn" id="test2">图片上传</button>
                <div class="layui-upload-list">
                    <img class="layui-upload-img" name="g_url" id="demo2" style="width: 100px;height: 100px">
                </div>
            </div>
        </div>--%>

        <%--商品简介--%>
        <div class="layui-form-item" style="margin-top: 2vw;">
            <label class="layui-form-label">商品简介</label>
            <div class="layui-input-block">
                <textarea name="g_profile" placeholder="请输入商品简介(不超过100字)" class="layui-textarea" maxlength="100"></textarea>
            </div>
        </div>
        <%--商品单价--%>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">商品单价</label>
            <div class="layui-input-block">
                <input type="text" name="g_money" autocomplete="off" class="layui-input">
            </div>
        </div>
        <%--商品数量--%>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">商品数量</label>
            <div class="layui-input-block">
                <input type="text" name="g_count" autocomplete="off" class="layui-input">
            </div>
        </div>
        <input type="submit" hidden="hidden" id="insertSubmit" value="确认">
    </form>
</div>
<div id="editForm" hidden="hidden">
    <form action="<%=request.getContextPath()%>/goods/update" class="form layui-form">
        <input type="hidden" name="g_id" id="g_id">
        <%--商品名称--%>
        <div class="layui-form-item" style="margin-top: 2vw;">
            <label class="layui-form-label">商品名称</label>
            <div class="layui-input-block">
                <input type="text" name="g_name" id="g_name" placeholder="请输入商品名称(不能包含空格数字)" autocomplete="off" class="layui-input"
                       onkeyup="value=value.replace(/[\d]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[\d]/g,''))"
                       maxlength="15">
            </div>
        </div>

        <%--商品生产日期--%>
        <div class="layui-form-item"  style="margin-top: 2vw;">
            <div class="layui-inline">
                <label class="layui-form-label">生产日期</label>
                <div class="layui-input-block">
                    <input type="text" name="g_date" id="g_date" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <%--商品图片--%>
        <div class="layui-form-item" style="margin-top: 2vw;">
            <label class="layui-form-label">商家图片：</label>
            <div class="layui-upload">
                <button type="button" class="layui-btn" id="test">上传图片</button>
                <input type="hidden" id="img_url" name="g_url"/>
                <div class="layui-upload-list">
                    <img class="layui-upload-img" name="g_url" id="g_url" th:value="${g_url}">
                    <p id="demoText"></p>
                </div>
            </div>
        </div>

        <%--商品简介--%>
        <div class="layui-form-item" style="margin-top: 2vw;">
            <label class="layui-form-label">商品简介</label>
            <div class="layui-input-block">
                <textarea name="g_profile" id="g_profile" placeholder="请输入商品简介(不超过100字)" class="layui-textarea" maxlength="100"></textarea>
            </div>
        </div>
        <%--商品单价--%>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">商品单价</label>
            <div class="layui-input-block">
                <input type="text" name="g_money" id="g_money" autocomplete="off" class="layui-input">
            </div>
        </div>
        <%--商品数量--%>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">商品数量</label>
            <div class="layui-input-block">
                <input type="text" name="g_count" id="g_count" autocomplete="off" class="layui-input">
            </div>
        </div>
        <input type="submit" hidden="hidden" id="updateSubmit" value="确认">
    </form>
</div>
<div class="layui-fluid">
    <table class="layui-table" id="demo" lay-filter="test"></table>
</div>
<script>
    layui.use(['table', 'laydate', 'form', 'util', 'layer'], function () {
        var table = layui.table;
        var laydate = layui.laydate;
        var layer = layui.layer;
        var util = layui.util;
        var form = layui.form;
        <c:if test="${flag}">
        $(function () {
            var index=layer.msg($("#msg").val());
            layer.style(index, {
                width: 'auto',
                height:'auto'
            });
        });
        </c:if>
        laydate.render({
            elem: '#g_date'
            ,type: 'datetime'
            , format: 'yyyy-MM-dd HH:mm:ss'
        });
        laydate.render({
            elem: '#g_date1'
            ,type: 'datetime'
            , format: 'yyyy-MM-dd HH:mm:ss'
        });
        form.render();
        //第一个实例
        var renderTable = function() {
        table.render({
            elem: '#demo'
            , url: '<%=request.getContextPath()%>/goods/goodsManager?condition=${condition}' //数据接口
            , page: true //开启分页
            , height: $(document).height()-$('#demo').offset().top-25
            , cols: [[ //表头
                {field: 'g_id', title: '商品ID', width: 120, sort: true}
                , {field: 'g_url', title: '商品图片', width: 180,sort: true}
                , {field: 'g_name', title: '商品名称', width: 180, sort: true}
                , {field: 'g_date', title: '商品生产日期',width: 180}
                , {field: 'g_profile', title: '商品简介', width: 180}
                , {field: 'g_money', title: '商品单价', width: 180}
                , {field: 'g_count', title: '商品数量', width: 180}
                , {
                    title: '操作', width: 180, align: 'center', toolbar: '' +
                        '<div class="layui-btn-group">' +
                        '<button type="button" class="layui-btn" lay-event="edit">编辑</button>' +
                        '<button type="button" class="layui-btn layui-btn-danger" lay-event="del">删除</button>' +
                        '</div>'
                }
            ]]
            , limits: [5, 10, 20]
            , toolbar: '<div class="layui-btn-group">' +
                '<button type="button" class="layui-btn" lay-event="add">增加</button>' +
                '<div class="layui-card search">\n' +
                '        <div class="layui-form layui-card-header layuiadmin-card-header-auto" >\n' +
                '            <div class="layui-form-item">' +
                '               <form type="post" action="<%=request.getContextPath()%>/goods/toGoods"> \n' +
                '                <div class="layui-inline">\n' +
                '                    <label class="layui-form-label hint">商品名称</label>\n' +
                '                    <div class="layui-input-block">\n' +
                '                        <input type="text" id="condition" name="condition" value="${condition}" placeholder="请输入要查询的商品名称" autocomplete="off" class="layui-input">\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '                <div class="layui-inline">\n' +
                '                    <button type="submit" class="layui-btn layuiadmin-btn-useradmin" id="sel">\n' +
                '                        <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>\n' +
                '                    </button>\n' +
                '                </div>' +
                '               </form>\n' +
                '            </div>\n' +
                '        </div>\n' +
                '    </div>' +
                '</div>'
        });
        };
        //头工具栏事件
        table.on('toolbar(test)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'add':
                    layer.open({
                        title: "添加",
                        type: 1,
                        area: ['30%', '70%'],
                        content: $("#addForm"),
                        btn: ['提交'],
                        yes: function (index, layero) {
                            layero.find("form").find("#insertSubmit").click();
                        }
                    });
                    break;
            }
            ;
        });

        renderTable();

        //监听行工具事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            var id = data.g_id;
            if (obj.event === 'del') {
                layer.confirm('是否确认删除', function (index) {
                    $.ajax({
                        type: "POST",
                        url: "<%=request.getContextPath()%>/goods/delete?g_id=" + id,
                        success: function (msg) {
                            obj.del();
                            renderTable();
                            layer.msg("删除成功");
                        },
                        error: function (msg) {
                            layer.msg("遇到意外错误");
                        }
                    });
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                $("#g_id").val(data.g_id);
                $("#g_name").val(data.g_name);
                $("#g_profile").val(data.g_profile);
                $("#g_money").val(data.g_money);
                $("#g_date").val(data.g_date);
                $("#g_count").val(data.g_count);
                $("#g_url").val(data.g_url);
                layer.open({
                    title: "修改",
                    type: 1,
                    area: ['30%', '70%'],
                    content: $("#editForm"),
                    btn: ['提交'],
                    success: function(){
                        form.render('select');
                    },
                    yes: function (index, layero) {
                        layero.find("form").find("#updateSubmit").click();
                    }
                });
            }
        });


    });

    layui.use('upload', function(){
        var $ = layui.jquery
            ,upload = layui.upload;

        //普通图片上传

        /*var uploadInst = upload.render({
            elem: '#test1'
            ,url: '/goods/upload'
            ,accept: 'images'
            ,acceptMime: 'image/!*'
            ,size: '1024*5'
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, g_url, result){
                    $('#g_url').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(json){
                //如果上传失败
                if(json.code == 0){
                    return layer.msg('上传失败-------');
                }
                //上传成功
                if(json.code > 0){
                    return layer.msg('上传成功--------');
                }
            }


        });

        var uploadInst = upload.render({
            elem: '#test2'
            ,url: '/goods/upload'
            ,accept: 'images'
            ,acceptMime: 'image/!*'
            ,size: '1024*5'
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, g_url, result){
                    $('#demo2').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(json){
                //如果上传失败
                if(json.code == 0){
                    return layer.msg('上传失败-------');
                }
                //上传成功
                if(json.code > 0){
                    return layer.msg('上传成功--------');
                }
            }


        });*/

        var uploadInst = upload.render({
            elem: '#test1'
            ,url: '<%=request.getContextPath()%>/goods/upload'
            ,before: function(obj){
                g_url = obj.pushFile(); //将每次选择的文件追加到文件队列
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, g_url, result){//回调函数达到预览效果
                    $('#g_url').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){ 　　　　//如果上传失败
                if(res.code > 0){
                    return layer.msg('上传失败');
                }
                //上传成功
                layer.msg(res.msg);
                // alert("上传成功"+res.msg);
                document.getElementById("img_url1").value = res.data.src;
                // document.getElementById("picture").value = res.data.src();
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText1');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });


        var uploadInst = upload.render({
            elem: '#test'
            ,url: '<%=request.getContextPath()%>/goods/upload'
            ,before: function(obj){
                g_url = obj.pushFile(); //将每次选择的文件追加到文件队列
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, g_url, result){//回调函数达到预览效果
                    $('#g_url').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){ 　　　　//如果上传失败
                if(res.code > 0){
                    return layer.msg('上传失败');
                }
                //上传成功
                layer.msg(res.msg);
                // alert("上传成功"+res.msg);
                document.getElementById("img_url").value = res.data.src;
                // document.getElementById("picture").value = res.data.src();
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });


    });
</script>
</body>
</html>
