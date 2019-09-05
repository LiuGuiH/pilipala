<%--
  Created by IntelliJ IDEA.
  User: liuguihua
  Date: 2019/7/26
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>噼里啪啦-用户信息</title>
</head>
<style type="text/css">
    body{
        background-image: url("<%=request.getContextPath()%>/static/user_img/showMessage.jpg");
        background-size: 130%;
    }
    div{
        margin-top: 100px;
    }
</style>
<body>
    <div>
        <div align="center">
            <p>姓名：${user.getName()}</p>
            <P>昵称：${user.getNickName()}</P>
            <p>性别：${user.getSex()}</p>
            <p>电话：${user.getPhone()}</p>
            <P>出生时间：${user.getBirthTime()}</P>
            <p>QQ：${user.getQQ()}</p>
            <P>邮箱：${user.getEmail()}</P>
            <p>地址：${user.getAddress()}</p>
            <p></p>
            <p><a href="<%=request.getContextPath()%>/web-jsp/index.jsp">返回首页</a></p>
        </div>
    </div>
</body>
</html>
