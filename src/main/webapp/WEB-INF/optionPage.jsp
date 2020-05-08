<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2020/5/7
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            background-image: url(/img/background-image.jpg);
        }
        .box1{height: 8vw;width: 30vw;top: 3vw;left: 35vw;background-color: rgba(255, 255, 255, 0.5);
            border-radius: 5px;position: absolute;overflow: hidden;}

        .box2{height: 8vw;width: 30vw;top: 13vw;left: 35vw;background-color: rgba(255, 255, 255, 0.5);
            border-radius: 5px;position: absolute;overflow: hidden;}
        .box3{height: 8vw;width: 30vw;top: 23vw;left: 35vw;background-color: rgba(255, 255, 255, 0.5);
            border-radius: 5px;position: absolute;overflow: hidden;}
        .box4{height: 8vw;width: 30vw;top: 33vw;left: 35vw;background-color: rgba(255, 255, 255, 0.5);
            border-radius: 5px;position: absolute;overflow: hidden;}
        .div1{
            font-size:30px;
            left: 135px;
            height: 10px;
            top:30px;
            position: absolute;
        }
        .div2{
            font-size:30px;
            left: 155px;
            height: 10px;
            top:40px;
            position: absolute;
        }
    </style>
</head>
<body>
    <a class="box1" href="/eye/exercisetime">
      <div class="div1"  >眼保健操</div>
    </a>
    <a class="box2" href="/eye/exercisetime">
        <div class="div1">望远运动</div>
    </a>
    <a class="box3" href="/eye/exercisetime">
        <div class="div2">烫眼法</div>
    </a>
    <a class="box4" href="/eye/exercisetime">
        <div class="div2">洗眼法</div>
    </a>
</body>
</html>
