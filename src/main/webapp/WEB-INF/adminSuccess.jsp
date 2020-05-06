<%--
  Created by IntelliJ IDEA.
  User: l
  Date: 2020/4/29
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>眼部保健管理平台</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
    <script src="../layui/layui.js"></script>
    <style type="text/css">

        .outer{
            background-color: #4E5465;
        }

        .top {
            width: 100%;
            background-image:url(/img/admin/admin_logo.png);
            background-repeat:no-repeat;
            background-position: 30px center;
            height: 13%;
        }

        .top span, .top a {
            position: relative;
            margin-top: 15px;
            right: 40px;
            float: right;
            color: white;
        }

        .top p {
            position: relative;
            top: 35px;
            text-align: center;
            font-size: 22px;
        }

        .left {
            width: 14.9%;
            height: 100%;
            background-color: #393D49;
        }

        #leftul{
            width: 100%;
        }

        .bottom {
            width: 100%;
            height: 86.9%;
        }

        .bottom div {
            float: left;
        }

        .main {
            width: 85%;
        }

        .main iframe {
            height: 100%;
            width: 100%;
        }

        #logout:hover {
            color: white;
        }
    </style>
</head>
<body>
<div class="outer">
    <div class="top">
        <span>尊敬的用户${loginName}您好，欢迎您的登陆</span><br><br>
        <a href="<%=request.getContextPath()%>/user/logout" id="logout">退出登录</a>
    </div>
</div>
<div class="bottom">
    <div class="left">
        <ul id="leftul" class="layui-nav layui-nav-tree layui-inline" lay-filter="demo">
            <!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
            <li class="layui-nav-item layui-nav-itemed">
                <a href="javascript:;">系统管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="<%=request.getContextPath()%>/adminNews/toNewsManage" target="maintarget">新闻动态管理</a></dd>
                    <dd><a href="<%=request.getContextPath()%>/adminQuestion/toQuestionManager" target="maintarget">常见问题管理</a></dd>
                    <dd><a href="<%=request.getContextPath()%>/" target="maintarget">上传商品信息</a></dd>
                </dl>
            </li>
        </ul>
    </div>
    <%--<script>
        layui.use('element', function () {
            var element = layui.element;
        });
    </script>--%>
    <div class="main">
        <iframe name="maintarget" frameborder="0"></iframe>
    </div>
</div>
</body>
<script>
    layui.use('element', function(){
    });
</script>
</html>
