<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<title>登录</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/styleLogin.css">

</head>
<body>

    <div>
        <div class="login-top">
            <h1 class="align-center">米克斯KTV</h1>
        </div>
        <h3 class="align-center font-gray">米克斯KTV后台管理系统</h3>

        <form role="form" action="user_login.action" method="post">
	        <div class="col-lg-4 col-lg-push-4 col-xs-4 col-xs-push-4">
	            <div class="form-group">
	                <input type="text" name="loginName" class="form-control" placeholder="登录名" required>
	            </div>
	            <div class="form-group">
	                <input type="password" name="md5Password" class="form-control" placeholder="密码" required="">
	            </div>
            	<button type="submit" class="btn btn-primary login-button">登录</button>
            	<a href="user_registerUI.action"><button type="button" class="btn btn-success login-button">注册</button></a>
    			<p class="xs-tip">如您忘记密码请联系系统管理员重置密码</p>
			</div>
        </form>
    </div>

	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="js/001.js"></script>
</body>
</html>