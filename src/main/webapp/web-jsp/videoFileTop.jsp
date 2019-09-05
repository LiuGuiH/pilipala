<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>劈里啪啦-视频投稿</title>
<script
	src="<%=request.getContextPath()%>/static/Homepage/js/jquery-2.0.0.js"></script>
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/Homepage/mycssAndimg/css.css">
</head>
<style>
 
    </style>
<body style="background-image: url(<%=request.getContextPath()%>/static/Homepage/mycssAndimg/timg.jpg);">
    	<div id="none">
    		<!-- style="width: 100%;height: 60px;background-color: white;" -->
    	</div>
    	
        <div>
          	 
            <div>

                <form id="upload_form" action="tougao.do" enctype="multipart/form-data" method="post">
                    <div>
                        <div><label for="video" style="color: wheat;">请选择投稿视频文件</label></div>
                        <div><input type="file" name="files" id="video" /></div>
                    </div>
                    <div>
                        <div><label for="img" style="color: wheat;">请选择投稿封面壁纸</label></div>
                        <div><input type="file" name="files" id="img" /></div>
                    </div>
                     <div>
                        <div><label for="biaoti" style="color: wheat;">请输入视频标题</label></div>
                        <div><input type="text" name="biaoti"  id="biaoti" /></div>
                    </div>
                     <div>
                        <div><label for="miaoshu" style="color: wheat;">请输入视频简介</label></div>
                        <div><textarea  rows="13" id="miaoshu" cols="70"></textarea></div>
                    </div>
                    <div>
                        <div><label for="daxiaobuneng" style="color: wheat;">请选择投放区域</label></div>
                        <div>
                        <label><input name="Fruit" type="radio" value="1"  checked />动画 </label> 
						<label><input name="Fruit" type="radio" value="2" />MAD </label> 
						<label><input name="Fruit" type="radio" value="3" />音乐 </label> 
						<label><input name="Fruit" type="radio" value="1" />影视 </label> 
						<label><input name="Fruit" type="radio" value="2" />原创 </label> 
                        </div>
					</div>
					<div>
                        <input type="submit" value="立即投稿">  <input type="button" id="fanhui" value="取消返回" />
                   	 </div>
					 </form>
						<div style="display: none;" id="daxiaobuneng"><b style="color: red;">总大小不能超过1g</b></div>
        </div>
        <script type="text/javascript">
        	$("#fanhui").click(function(){
        		location.href = "index.do";
        	})
        </script>
        </div>
    </body>



</html>