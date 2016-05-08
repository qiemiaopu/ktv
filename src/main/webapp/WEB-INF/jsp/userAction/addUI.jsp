<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <title>添加用户</title>

    <!-- 主包 -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
    <!-- dataTables包 -->
    <link href="css/dataTables/dataTables.bootstrap.css" rel="stylesheet">
    <link href="css/dataTables/dataTables.responsive.css" rel="stylesheet">
    <link href="css/dataTables/dataTables.tableTools.min.css" rel="stylesheet">
    <!-- 本地包 -->
    <link rel="stylesheet" type="text/css" href="css/w.css"></head>

<body>
<%@ include file="/WEB-INF/jsp/public/title.jspf"%>
    <div style="margin:100px auto;width:800px;">
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <div class="row">
                            <h5 style="margin:0 0 10px 15px;"> <b>添加用户</b>
                            </h5>
                        </div>
                        <div class="ibox-content">
                            <form method="post" action="user_add" class="form-horizontal">
                                <!-- 第一个输入框 -->
                                <div class="form-group">
                                    <label class="col-lg-1 control-label">账号</label>
                                    <div class="col-lg-11">
                                        <input id="create_username" name="username" type="text" placeholder="请输入账号" class="form-control">
                                        <span class="help-block m-b-none"></span>
                                    </div>
                                </div>
                                <!-- 第二个输入框 -->
                                <div class="form-group">
                                    <label class="col-lg-1 control-label">密码</label>
                                    <div class="col-lg-11">
                                        <input id="create_password" name="password" type="text" placeholder="请输入密码" class="form-control">
                                        <span class="help-block m-b-none"></span>
                                    </div>
                                </div>
                                <!-- 第三个输入框 -->
                                <div class="form-group">
                                    <label class="col-lg-1 control-label">姓名</label>
                                    <div class="col-lg-11">
                                        <input id="create_personname" name="personname" type="text" placeholder="请输入姓名" class="form-control">
                                        <span class="help-block m-b-none"></span>
                                    </div>
                                </div>
                                <!-- 第四个输入框 -->
                                <div class="form-group">
                                    <label class="col-lg-1 control-label">手机</label>
                                    <div class="col-lg-11">
                                        <input id="create_userphone" name="userphone" type="text" placeholder="请输入手机号" class="form-control">
                                        <span class="help-block m-b-none"></span>
                                    </div>
                                </div>
                                <!-- 第五个输入框 -->
                                <div class="form-group">
                                    <label class="col-lg-1 control-label">备注</label>
                                    <div class="col-lg-11">
                                        <input id="create_remark" name="remark" type="text" placeholder="请输入备注" class="form-control">
                                        <span class="help-block m-b-none"></span>
                                    </div>
                                </div>
                                <!-- 第一组按钮 -->
                                <div class="form-group">
                                    <div class="col-lg-6 col-lg-offset-1">
                                        <button id="w-create-submit" type="button" class="btn btn-primary" style="float:left">保存设置</button>
                                        <button id="w-create-cancel" type="button" class="btn btn-default" style="float:left">取消设置</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 基础包 -->
    <script src="js/jquery-1.10.2.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <!-- 本地包 -->

    <script src="js/001.js"></script>

</body>
</html>