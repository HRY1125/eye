<%--
  Created by IntelliJ IDEA.
  User: Anduin
  Date: 2020/5/1
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="../css/homePage/layout.css">
    <link rel="stylesheet" type="text/css" href="../css/homePage/base.css">
    <link rel="stylesheet" type="text/css" href="../css/homePage/ui.css">
    <script src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/homePage/ui.js"></script>
</head>
<body>
<div id="top" class="top">
    <div class="wrap">
        <p class="call">欢迎来到眼科保健医院</p>
        <p class="welcome">请&nbsp;
            <a href="#">登录</a>
            <a href="#">注册</a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="#">帮助</a>
        </p>
    </div>
</div>
<div id="header" class="header">
    <div class="wrap clearfix">
        <a class="logo" href="#"><img src="../img/homePage/logo.png"></a>
        <div class="search ui-search">
            <div class="ui-search-selected">护眼</div>
            <input type="text" name="search-content" class="ui-search-input" placeholder="请输入搜索内容">
            <a href="#" class="ui-search-submit">&nbsp;</a>
        </div>
    </div>
</div>
<div id="nav" class="nav">
    <div class="wrap">
        <a href="#" id="link_left" class="link">网站首页</a>
        <a href="#" class="link">医院概览</a>
        <a href="#" class="link">医院文化</a>
        <a href="#" class="link">最新公告</a>
        <a href="#" class="link right">眼保健操</a>
    </div>
</div>
<div id="banner" class="banner">
    <div class="banner-slider ui-slider">
        <div class="ui-slider-wrap">
            <a href="#" class="item"><img class="item_img" src="../img/homePage/banner_1.jpg"></a>
            <a href="#" class="item"><img class="item_img" src="../img/homePage/banner_2.jpg"></a>
            <a href="#" class="item"><img class="item_img" src="../img/homePage/banner_3.jpg"></a>
        </div>
        <div class="ui-slider-arrow">
            <a href="#" class="item left">&nbsp;</a>
            <a href="#" class="item right">&nbsp;</a>
        </div>
        <div class="ui-slider-process">
            <a href="#" class="item item_focus">&nbsp;</a>
            <a href="#" class="item item">&nbsp;</a>
            <a href="#" class="item item">&nbsp;</a>
        </div>
    </div>
</div>
<div id="content" class="content">
    <div class="wrap clearfix">
        <div class="content-tab">
            <div class="caption">
                <a href="#8" class="item item_focus">医院新闻</a>
            </div>
            <div class="block">
                <div class="item">
                    <div class="block-caption">

                    </div>
                    <div class="block-content">
                        <div class="block-wrap">
                            <div class="block-list clearfix">
                                <div class="item">
                                    <img src="../img/homePage/hospital-1.jpg" alt="新闻" ／>
                                    <div class="item-name">新闻标题</div>
                                    <div class="item-address">新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容</div>
                                </div>
                                <div class="item">
                                    <img src="../img/homePage/hospital-1.jpg" alt="新闻" ／>
                                    <div class="item-name">新闻标题</div>
                                    <div class="item-address">新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容</div>
                                </div>
                                <div class="item">
                                    <img src="../img/homePage/hospital-1.jpg" alt="新闻" ／>
                                    <div class="item-name">新闻标题</div>
                                    <div class="item-address">新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容</div>
                                </div>
                                <div class="item">
                                    <img src="../img/homePage/hospital-1.jpg" alt="新闻" ／>
                                    <div class="item-name">新闻标题</div>
                                    <div class="item-address">新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容</div>
                                </div>
                                <div class="item">
                                    <img src="../img/homePage/hospital-1.jpg" alt="新闻" ／>
                                    <div class="item-name">新闻标题</div>
                                    <div class="item-address">新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容</div>
                                </div>
                                <div class="item">
                                    <img src="../img/homePage/hospital-1.jpg" alt="新闻" ／>
                                    <div class="item-name">新闻标题</div>
                                    <div class="item-address">新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <c:if test="${nUserId!= null and nUserId!=''}">
        <div class="content-news">
            <div class="caption"> 新闻通知 <a href="#" class="more">更多</a> </div>
            <div class="list">
                <c:forEach items="${newsList}" var="news" begin="0" end="5">
                <a href="#" class="link">${news.nTitle}</a>
                </c:forEach>
            </div>
        </div>
        </c:if>
        <div class="content-close">
            <div class="caption"> 医院公告 <a href="#" class="more">更多</a> </div>
            <div class="list">
                <a href="#" class="link">公告系统升级通知</a>
                <a href="#" class="link">公告系统升级通知</a>
                <a href="#" class="link">公告系统升级通知</a>
                <a href="#" class="link">公告系统升级通知</a>
                <a href="#" class="link">公告系统升级通知</a>
                <a href="#" class="link">公告系统升级通知</a>
            </div>
        </div>
    </div>
</div>
<div id="footer" class="footer">
    Copyright © 眼科保健医院版权所有
</div>
</body>
</html>
