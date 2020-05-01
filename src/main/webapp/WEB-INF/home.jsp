<%--
  Created by IntelliJ IDEA.
  User: wy
  Date: 2020/4/28
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
登录成功！
首页进来了~~~
<c:if test="${userName!=null}">
    欢迎：${userName}
</c:if>
<c:if test="${userName==null}">
    欢迎：${doctorName}医生
</c:if>
</body>
</html>
