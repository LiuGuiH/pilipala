<%@ page import="pojo.Message" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: LiSA
  Date: 2019/7/25
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><script type="text/javascript">
    function a() {
    $.ajax({
        url: "view.do",
        type: "GET",
        success:function (e) {
            <%
            System.out.println(1234564);
            %>
        }
});
}
</script>
    <script src="js/jquery-3.2.1.js"></script>
    <title>Title</title>
</head>
<body onload="a()">
<center>
<font size="4" color="black"><strong><p>用户评论</p></strong></font>
<form id="comment" action="${pageContext.request.contextPath}/helpComment.do1" method="post">
    <input type="hidden" name="videoID" value="1">
    <textarea style="border-color:deepskyblue;box-shadow: 0 0 10px deepskyblue" cols="70" rows="3" name="message"></textarea>
    <input style="width: 80px;height:50px;background-color: deepskyblue;color: white" type="submit" value="发表评论">
</form>
<br>
<table>
<%--<form action="${pageContext.request.contextPath}/view.do" method="post">--%>
<%--    <input type="submit" value="显示评论"></form>--%>
    <br><br>

    <c:forEach items="${messages}" var="message">
        <p style="color: red;">留言者:<a href="" style="color: darkgoldenrod;text-decoration:none;">&nbsp;${message.messageuserName}</a><span style="color: blue;"></span></p>
        <div style="font-size:large">${message.message}</div>
        <%--        <form action="${pageContext.request.contextPath}/reply.do"></form>--%>
    </c:forEach>
</table>
</center>
</body>
</html>
