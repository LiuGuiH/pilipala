<%@ page import="pojo.Admin" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: YT
  Date: 2019/7/26
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/h-ui.admin/css/style.css" />
    <title>我的桌面</title>
</head>
<body>
<div class="page-container">
    <p class="f-20 text-success">欢迎使用噼里啪啦<span class="f-14">V0.01</span>后台模版！</p>
    <p>登录次数：18 </p>
    <p>上次登录IP<%=request.getRemoteAddr()%> 上次登录时间:2019-07-26 10:23:12</p>
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr>
            <th colspan="7" scope="col">信息统计</th>
        </tr>
        <tr class="text-c">
            <th>统计</th>
            <th>视频库</th>
            <th>用户</th>
            <th>评论</th>
            <th>管理员</th>
        </tr>
        </thead>
        <tbody>
        <tr class="text-c">
            <td>总数</td>
            <td><%=((List)request.getSession().getAttribute("totalVideo")).size()%></td>
            <td><%=((List)request.getSession().getAttribute("totalUser")).size()%></td>
            <td><%=((List)request.getSession().getAttribute("totalMessage")).size()%></td>
            <td><%=((List)request.getSession().getAttribute("totalAdmin")).size()%></td>
        </tr>
        <tr class="text-c">
            <td>今日</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
        </tr>
        <tr class="text-c">
            <td>昨日</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
        </tr>
        <tr class="text-c">
            <td>本周</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
        </tr>
        <tr class="text-c">
            <td>本月</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
        </tr>
        </tbody>
    </table>
    <table class="table table-border table-bordered table-bg mt-20">
        <thead>
        <tr>
            <th colspan="2" scope="col">服务器信息</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th width="30%">服务器计算机名</th>
            <td><span id="lbServerName"><%=request.getLocalName()%></span></td>
        </tr>
        <tr>
            <td>服务器IP地址</td>
            <td><%=request.getLocalAddr()%></td>
        </tr>
        <tr>
            <td>服务器域名</td>
            <td>ss.slane.me</td>
        </tr>
        <tr>
            <td>服务器端口 </td>
            <td><%=request.getRemotePort()%></td>
        </tr>
        <tr>
            <td>服务器IIS版本 </td>
            <td>Microsoft-IIS/6.0</td>
        </tr>
        <tr>
            <td>本文件所在文件夹 </td>
            <td>D:\WebSite\HanXiPuTai.com\XinYiCMS.Web\</td>
        </tr>
        <tr>
            <td>服务器操作系统 </td>
            <td>Microsoft Windows NT 5.2.3790 Service Pack 2</td>
        </tr>
        <tr>
            <td>系统所在文件夹 </td>
            <td>C:\WINDOWS\system32</td>
        </tr>
        <tr>
            <td>服务器脚本超时时间 </td>
            <td>30000秒</td>
        </tr>
        <tr>
            <td>服务器的语言种类 </td>
            <td>Chinese (People's Republic of China)</td>
        </tr>
        <tr>
            <td>.NET Framework 版本 </td>
            <td>2.050727.3655</td>
        </tr>
        <tr>
            <td>服务器当前时间 </td>
            <td>2014-6-14 12:06:23</td>
        </tr>
        <tr>
            <td>服务器IE版本 </td>
            <td>6.0000</td>
        </tr>
        <tr>
            <td>服务器上次启动到现在已运行 </td>
            <td>7210分钟</td>
        </tr>
        <tr>
            <td>逻辑驱动器 </td>
            <td>C:\D:\</td>
        </tr>
        <tr>
            <td>CPU 总数 </td>
            <td>4</td>
        </tr>
        <tr>
            <td>CPU 类型 </td>
            <td>x86 Family 6 Model 42 Stepping 1, GenuineIntel</td>
        </tr>
        <tr>
            <td>虚拟内存 </td>
            <td>52480M</td>
        </tr>
        <tr>
            <td>当前程序占用内存 </td>
            <td>3.29M</td>
        </tr>
        <tr>
            <td>Asp.net所占内存 </td>
            <td>51.46M</td>
        </tr>
        <tr>
            <td>当前Session数量 </td>
            <td>8</td>
        </tr>
        <tr>
            <td>当前SessionID </td>
            <td><%=request.getSession().getId()%></td>
        </tr>
        <tr>
            <td>当前系统用户名 </td>
            <td><%=((Admin) request.getSession().getAttribute("admin")).getAdmin_name()%></td>
        </tr>
        </tbody>
    </table>
</div>
<footer class="footer mt-20">
    <div class="container">
        <p>感谢jQuery、layer、laypage、Validform、UEditor、My97DatePicker、iconfont、Datatables、WebUploaded、icheck、highcharts、bootstrap-Switch<br>
            Copyright &copy;2015-2017 H-ui.admin v3.1 All Rights Reserved.<br>
            本后台系统由<a href="http://www.h-ui.net/" target="_blank" title="H-ui前端框架">H-ui前端框架</a>提供前端技术支持</p>
        <p>More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
    </div>
</footer>
<script type="text/javascript" src="<%=request.getContextPath()%>/style/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/static/h-ui/js/H-ui.min.js"></script>

</body>
</html>