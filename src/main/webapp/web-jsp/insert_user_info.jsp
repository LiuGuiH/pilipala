<%--
  Created by IntelliJ IDEA.
  User: liuguihua
  Date: 2019/7/25
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>噼里啪啦-修改信息</title>
</head>
<style type="text/css">
    .el-form-item__content {
        line-height: 30px;
    }
    #A{
        width: 200px;
        height: 30px;
    }
    textarea{
        width: 200px;
    }
    div,label{
        margin-bottom: 10px;
    }
    body{
        background-image: url("<%=request.getContextPath()%>/static/user_img/modifyMessage.jpg");
        background-size: 120%;
    }
</style>
<body>
<div style="font-size: larger;margin-left: 650px;margin-top: 100px;">
    <div class="security-right-title">
        <span class="security-right-title-icon"></span>
        <span class="security-right-title-text" style="font-size: 50px">我的信息</span>
    </div>
    <div class="user-setting-warp" style="font-size: larger">
        <div>
            <form class="el-form clearfix" action="<%=request.getContextPath()%>/insert_user_info.do2" mode="[object Object]">
                <div class="el-form-item user-nick-rel-name">
                    <label class="el-form-item__label">用户名:</label>
                    <div class="el-form-item__content">
                        <span class="userinfo-username">${user.getName()}</span>
                    </div>
                </div>
                <div class="el-form-item user-name">
                    <label class="el-form-item__label">姓名:</label>
                    <div class="el-form-item__content">
                        <div class="el-input">
                            <input autocomplete="off" id="A" name="newName" placeholder="你的姓名" type="text" rows="2" maxlength="16" validateevent="true" class="el-input__inner">
                        </div>
                    </div>
                </div>
                <div class="el-form-item user-my-sex">
                    <label class="el-form-item__label">性别:</label>
                    <div class="el-form-item__content">
                        <div class="el-radio-group">
                            <label class="el-radio-button">
                                <input type="radio" class="el-radio-button__orig-radio" name="sex" checked="checked" value="男">
                                <span class="el-radio-button__inner">男</span>
                            </label>
                            <label class="el-radio-button">
                                <input type="radio" class="el-radio-button__orig-radio" name="sex" checked="checked" value="女">
                                <span class="el-radio-button__inner">女</span>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="el-form-item user-brith-day">
                    <label class="el-form-item__label">出生日期:</label>
                    <div class="el-form-item__content">
                        <div class="el-input">
                            <input autocomplete="off" name="newDate" placeholder="你的出生时间：如1998-11-10" id="A" type="text" rows="2" maxlength="16" validateevent="true" class="el-input__inner">
                        </div>
                    </div>
                </div>
                <div class="el-form-item user-QQ">
                    <label class="el-form-item__label">QQ:</label>
                    <div class="el-form-item__content">
                        <div class="el-input">
                            <input autocomplete="off" name="newQQ" placeholder="你的QQ" id="A" type="text" rows="2" maxlength="16" validateevent="true" class="el-input__inner">
                        </div>
                    </div>
                </div>
                <div class="el-form-item user-my-address">
                    <label class="el-form-item__label">我的地址:</label>
                    <div class="el-form-item__content">
                        <div class="el-textarea">
                            <textarea placeholder="设置您的地址" name="newAddress"  type="textarea" rows="3" autocomplete="off" validateevent="true" class="el-textarea__inner"></textarea>
                        </div>
                    </div>
                </div>
                <div class="el-form-item user-my-btn">
                    <div class="el-form-item__content">
                        <div class="padding-dom"></div>
                        <p></p>
                        <div class="user-my-btn-warp" style="text-indent: 2em;">
                            <input type="submit" value="保存" class="el-button el-button--primary" style="background-color: #00FFF6;font-size: large"/>
                            <input type="reset" value="取消" style="background-color: #00FFF6;font-size: large"/>
                        </div>
                    </div>
                </div>
                <p></p>
                <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/web-jsp/index.jsp">返回首页</a></p>
            </form>
        </div>
    </div>
</div>
</body>
</html>
