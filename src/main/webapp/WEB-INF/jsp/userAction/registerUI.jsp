<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
	<title>注册</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/styleLogin.css">

</head>
<body>
    <div>
        <h3 class="align-center font-gray">账号注册</h3>
        <form role="form" action="user_register.action">
	        <div class="col-lg-4 col-lg-push-4 col-xs-4 col-xs-push-4">
	            <div class="form-group">
	                <input type="text" name="loginName" class="form-control" placeholder="登录名" required="">
	            </div>
	            <div class="form-group">
	                <input type="password" name="md5Password" class="form-control" placeholder="密码" required="">
	            </div>
	            <div class="form-group">
	                <input type="password" name="rePassword" class="form-control" placeholder="确认密码" required="">
	            </div>
	            <div class="form-group">
	                <input type="text" name="name" class="form-control" placeholder="姓名" required="">
	            </div>
	            <div class="form-group">
	                <input type="text" name="phone" class="form-control" placeholder="手机号" required="">
	            </div>

            	<button type="submit" class="btn btn-success register-button">注册</button>
            	<!-- <button type="submit" class="btn btn-success login-button">账号已有</button> -->


    			<p class="xs-tip">如您忘记密码请联系系统管理员重置密码</p>
			</div>
        </form>
    </div>

	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="js/001.js"></script>
</body>
</html>