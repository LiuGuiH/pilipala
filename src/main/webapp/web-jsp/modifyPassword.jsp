<%--
  Created by IntelliJ IDEA.
  User: liuguihua
  Date: 2019/7/26
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>噼里啪啦-修改密码</title>
</head>
<style type="text/css">
    body{
        background-image: url("<%=request.getContextPath()%>/static/user_img/modifyPassword.jpg");
        background-size: 100%;
    }
</style>
<body>
    <div align="center" style="margin-top: 150px">

            <label style="color: #4b9500;font-size: larger;">修改密码</label>
            <form action="modifyPassword.do2" method="post">
                <P>&nbsp;&nbsp;&nbsp;用户名：${userName}</P>
                <P>&nbsp;&nbsp;&nbsp;新密码：<input type="password" name="modifyPassword1" /></P>
                <P>再次输入：<input type="password" name="modifyPassword2" /><font color="red">${modify_mes}</font></P>
                <input type="submit" value="保存"/>&nbsp;&nbsp;<input type="reset" value="取消"/>

                <p></p>
                <p><a href="<%=request.getContextPath()%>/web-jsp/index.jsp">返回首页</a></p>
            </form>

    </div>
</body>
</html>
