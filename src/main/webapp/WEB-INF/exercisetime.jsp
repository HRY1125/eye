<%--
  Created by IntelliJ IDEA.
  User: EDZ
  Date: 2020/4/28
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        button{
            width: 100px;
            height: 60px;
            font-size: 27px;
        }
        #time{
            height: 100px;
            font-size: 35px;
        }
        #second{
            border: 0;
            outline: none;
            background-color: rgba(0, 0, 0, 0);
            font-size: 35px;
            width: 100px;
        }
    </style>
    <script type="text/javascript">
        var s=0;
        var t;
        function timedCount()
        {
            document.getElementById('second').value=s;
            s=s+1;
            t=setTimeout("timedCount()",1000);
        }
        function stopCount()
        {
            clearTimeout(t);
        }
    </script>
</head>
<body>
    <div id="time">
        <center>
            <input type="text" id="second">秒
        </center>
    </div>
    <div id="switch">
        <center>
            <button onClick="timedCount()">开始</button>
            <button onClick="stopCount()">停止</button>
            <button onclick="">提交</button>
        </center>
    </div>
</body>
</html>
