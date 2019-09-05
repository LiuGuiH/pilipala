<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>噼里啪啦-登录</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/login/loginnew/css/default.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/login/loginnew/css/styles.css">
<script src="<%=request.getContextPath()%>/static/Homepage/js/jquery.min.js"></script>
	<%--<script type="text/javascript">
		$(function (){

		$("#tijiao").click(function () {
			var url="login.do";
			$.post(url,function (data) {
				var s=eval(data);
				alert(s);
			})
		})

		})
	</script>--%>
</head>
<body>
<article class="htmleaf-container">
		<header class="htmleaf-header">
			</div>
		</header>
		<div class="panel-lite">
		  <div class="thumbur">
		    <div class="icon-lock"></div>
		  </div>
		  <form action="<%=request.getContextPath()%>/LoginServlet" method="post">
		  <h4>用户登录</h4>
		  <div class="form-group">
		    <input required="required" name="userName" id="userName" class="form-control"/>
		    <label class="form-label">用户名    </label>
		  </div>
		  <div class="form-group">
		    <input type="password" name="passWord" id="passWord" required="required" class="form-control"/>
		    <label class="form-label">密　码</label>
		  </div>
		  <div>
		  </div>
		  <a href="#">忘记密码 ?  </a>    <a href="<%=request.getContextPath()%>/web-jsp/register.jsp">立即注册? </a>
		  <br>
		    <a href="<%=request.getContextPath()%>/web-jsp/index.jsp">返回首页 </a>
		  <button class="floating-btn" id="tijiao"><i class="icon-arrow"></i></button><font color="red">${mes}</font>
		</form>
		</div>
	</article>
</body>
</html>