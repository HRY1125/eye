<%--
  Created by IntelliJ IDEA.
  User: wy
  Date: 2020/4/28
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>眼保健操系统注册</title>
    <script src="/js/jquery.min.js"></script>
    <link href="/css/user/registered.css" rel="stylesheet">
    <style>.wrong{display: block}</style>
</head>
<body>
<div class="box">
    <div class="tab">
        <span class="user active" onclick="user()">用户</span>
        <span class="doctor" onclick="doctor()">医生</span>
    </div>
    <div class="form">
        <!-- 用户注册 -->
        <div class="wrong">${wrong}</div>
        <form class="user_form" action="<%=request.getContextPath()%>/addUser" method="post"
              onsubmit="return userCheck()">
            <div class="inputinfo">
                <img src="/img/name.png">
                <input class="input" type="text" name="userName" placeholder="请输入用户名"
                       maxlength="6" required/>
                <p class="wrong"></p>
            </div>
            <div class="inputinfo">
                <img src="/img/phone.png">
                <input class="input" type="text" name="userPhonenum" placeholder="请输入手机号"
                       maxlength="11" required id="user_phone" onchange="user_phone()"/>
                <p id="user_wrongPhone" class="wrong"></p>
            </div>
            <div class="inputinfo">
                <img src="/img/pwd.png">
                <input class="input" type="password" name="userPwd" placeholder="请输入密码"
                       maxlength="10" required id="user_pwd1" onchange="user_pwd1()"/>
                <p id="user_wrongPwd1" class="wrong"></p>
            </div>
            <div class="inputinfo">
                <img src="/img/pwd.png">
                <input class="input" type="password" placeholder="请确认密码" maxlength="10"
                       required id="user_pwd2" onchange="user_pwd2()"/>
                <p id="user_wrongPwd2" class="wrong"></p>
            </div>
            <div class="inputinfo">
                <input class="login" type="submit" value="注册" />
            </div>
        </form>
        <!-- 医生注册 -->
        <form class="doctor_form" action="<%=request.getContextPath()%>/addDoctor" method="post"
              onsubmit="return doctorCheck()">
            <div class="inputinfo">
                <img src="/img/name.png">
                <input class="input" type="text" name="doctorName" placeholder="请输入医生用户名"
                       maxlength="10" required/>
                <p class="wrong"></p>
            </div>
            <div class="inputinfo">
                <img src="/img/phone.png">
                <input class="input" type="text" name="doctorPhonenum" placeholder="请输入手机号"
                       maxlength="11" required id="doctor_phone" onchange="doctor_phone()"/>
                <p id="doctor_wrongPhone" class="wrong"></p>
            </div>
            <div class="inputinfo">
                <img src="/img/pwd.png">
                <input class="input" type="password" name="doctorPwd" placeholder="请输入密码"
                       maxlength="10" required id="doctor_pwd1" onchange="doctor_pwd1()"/>
                <p id="doctor_wrongPwd1" class="wrong"></p>
            </div>
            <div class="inputinfo">
                <img src="/img/pwd.png">
                <input class="input" type="password" placeholder="请确认密码" maxlength="10"
                       required id="doctor_pwd2" onchange="doctor_pwd2()"/>
                <p id="doctor_wrongPwd2" class="wrong"></p>
            </div>
            <div class="inputinfo">
                <input class="login" type="submit" value="注册" />
            </div>
        </form>
    </div>
</div>
<script type="text/javascript">
    //选项卡
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
    //用户手机号验证
    function user_phone() {
        var regPhone = /^1([356789]\d|5[0-35-9]|7[3678])\d{8}$/;
        var phone = document.getElementById("user_phone").value;
        var bool = regPhone.test(phone);
        if(bool == true){
            document.getElementById("user_wrongPhone").innerHTML="";
            return true;
        } else {
            document.getElementById("user_wrongPhone").innerHTML="请输入正确的手机号";
            return false;
        }
    }
    //用户密码正则
    function user_pwd1() {
        var check = false;
        var pwd = document.getElementById("user_pwd1").value;
        if (pwd.length === 6) {
            document.getElementById("user_wrongPwd1").innerHTML = "";
            check = true;
        } else {
            document.getElementById("user_wrongPwd1").innerHTML = "密码必须是六位！";
            check = false;
        }
        return check;
    }
    //用户确认密码
    function user_pwd2() {
        var check = false;
        var pwd1 = document.getElementById("user_pwd1").value;
        var pwd2 = document.getElementById("user_pwd2").value;
        if (pwd1 != pwd2) {
            document.getElementById("user_wrongPwd2").innerHTML = "两次输入密码不一致";
            check = false;
        } else {
            document.getElementById("user_wrongPwd2").innerHTML = "";
            check = true;
        }
        return check;
    }
    function userCheck(){
        var check = user_phone() && user_pwd1() && user_pwd2();
        return check;
    }
    //医生手机号正则
    function doctor_phone() {
        var regPhone = /^1([356789]\d|5[0-35-9]|7[3678])\d{8}$/;
        var phone = document.getElementById("doctor_phone").value;
        var bool = regPhone.test(phone);
        if(bool == true){
            document.getElementById("doctor_wrongPhone").innerHTML="";
            return true;
        } else {
            document.getElementById("doctor_wrongPhone").innerHTML="请输入正确的手机号";
            return false;
        }
    }
    //医生密码正则
    function doctor_pwd1() {
        var check = false;
        var pwd = document.getElementById("doctor_pwd1").value;
        if (pwd.length === 6) {
            document.getElementById("doctor_wrongPwd1").innerHTML = "";
            check = true;
        } else {
            document.getElementById("doctor_wrongPwd1").innerHTML = "密码必须是六位！";
            check = false;
        }
        return check;
    }
    //医生确认密码
    function doctor_pwd2() {
        var check = false;
        var pwd1 = document.getElementById("doctor_pwd1").value;
        var pwd2 = document.getElementById("doctor_pwd2").value;
        if (pwd1 != pwd2) {
            document.getElementById("doctor_wrongPwd2").innerHTML = "两次输入密码不一致";
            check = false;
        } else {
            document.getElementById("doctor_wrongPwd2").innerHTML = "";
            check = true;
        }
        return check;
    }
    function doctorCheck(){
        var check = doctor_phone() && doctor_pwd1() && doctor_pwd2();
        return check;
    }
</script>
</body>
</html>
