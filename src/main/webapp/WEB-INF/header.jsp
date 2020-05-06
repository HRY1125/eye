<%--
  Created by IntelliJ IDEA.
  User: wy
  Date: 2020/5/1
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>头部</title>
    <style>
        *{margin: 0;padding: 0;}
        .header{width: 100%;height: 4vw;border-bottom: 1px #989898;box-shadow: 1px 1px 5px 3px #d4d4d4;}
        .header-left{float: left;margin-left: 15vw;}
        .header-right{float: right;margin-right: 5vw;}
        .header ul li{list-style: none;float: left;}
        .header a{text-decoration: none;color: #000;line-height: 3.5vw;font-size: 17px;margin: 0 1vw;}
        .header .a:hover{color: #914EF3;}
        .header img{width: 2vw;height: 2vw;margin-top: 1vw;}
    </style>
</head>
<body>
<div class="header">
    <div class="header-left">
        <ul>
            <li><a class="a" href="javascript:;">首页</a></li>
            <li><a class="a" href="javascript:;">个人中心</a></li>
            <li><a class="a" href="javascript:;">购物车</a></li>
        </ul>
    </div>
    <div class="header-right">
        <ul>
            <li><a>欢迎：${name}</a></li>
            <li><a class="a" href="<%=request.getContextPath()%>/">退出</a></li>
        </ul>
    </div>
</div>
</body>
</html>
