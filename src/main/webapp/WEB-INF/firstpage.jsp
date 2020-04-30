<%--
  Created by IntelliJ IDEA.
  User: wy
  Date: 2020/4/28
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>眼保健操系统登录</title>
    <script src="/js/jquery.min.js"></script>
    <link href="/css/user/firstpage.css" rel="stylesheet">
    <%--<style>
        *{margin: 0;padding: 0;}
        body{background-image: url(/img/background-image.jpg);}
        .box{height: 25vw;width: 30vw;margin: 0 auto;margin-top: 10vw;background-color: rgba(255, 255, 255, 0.5);border-radius: 5px;}
        .box .tab{height: 4vw;line-height: 4vw;text-align: center;padding-top: 2vw;}
        .box .tab span{margin: 1vw;}
        .box ul{text-align: center;}
        .box ul li{list-style: none;}
        .active{color: #022b7b;font-size: 20px;font-weight: bold;}
        .box .tab span:hover{cursor: pointer;color: #022b7b;font-weight: bold;}
        .inputinfo{margin: 2vw;}
        .form{text-align: center;}
        .form img{height: 2vw;width: 2vw;position: absolute;padding: 4px;}
        .form .input{height: 2.5vw;width: 15vw;border: none;background-color: rgba(255, 255, 255, 0.5);border-radius: 5px;text-indent: 2.5rem;}
        .inputinfo .login{background-color: #42a3d0;border: none;height: 2vw;width: 5vw;color: #fff;font-size: 16px;margin: 1vw;border-radius: 3px;cursor: pointer;}
        .doctor_form{display: none;}
        .clear{clear: both}
    </style>--%>
</head>
<body>
<div class="box">
    <div class="tab">
        <span class="user active" onclick="user()">用户</span>
        <span class="doctor" onclick="doctor()">医生</span>
    </div>
    <div class="form">
        <!-- 用户登录 -->
        <div class="wrong">${wrong}</div>
        <form class="user_form" action="<%=request.getContextPath()%>/userLogin" method="post">
            <div class="inputinfo">
                <img src="/img/name.png">
                <input class="input" type="text" name="userName" placeholder="请输入用户名" required="required" />
            </div>
            <div class="inputinfo">
                <img src="/img/pwd.png">
                <input class="input" type="password" name="userPwd" placeholder="请输入密码" required="required" />
            </div>
            <div class="inputinfo">
                <input class="login" type="submit" value="登录" />
                <a href="<%=request.getContextPath()%>/toRegistered">
                    <input class="login" type="button" value="注册" />
                </a>
            </div>
        </form>
        <!-- 医生登录 -->
        <form class="doctor_form" action="" method="post">
            <div class="inputinfo">
                <img src="/img/name.png">
                <input class="input" type="text" name="doctorName" placeholder="请输入医生用户名" required="required" />
            </div>
            <div class="inputinfo">
                <img src="/img/pwd.png">
                <input class="input" type="password" name="doctorPwd" placeholder="请输入密码" required="required" />
            </div>
            <div class="inputinfo">
                <input class="login" type="submit" value="登录" />
                <a href="<%=request.getContextPath()%>/toRegistered">
                    <input class="login" type="button" value="注册" />
                </a>
            </div>
        </form>
    </div>
</div>
<script>
    /*选项卡点击事件*/
    function user(){
        $(".user_form").show(500);
        $(".doctor_form").hide(500);
        $(".user").addClass("active");
        $(".doctor").removeClass("active");
    }
    function doctor(){
        $(".doctor_form").show(500);
        $(".user_form").hide(500);
        $(".doctor").addClass("active");
        $(".user").removeClass("active");
    }
</script>
</body>
</html>
