<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <title>用户信息</title>



<!-- 主包 -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
<!-- dataTables包 -->
    <link href="css/dataTables/dataTables.bootstrap.css" rel="stylesheet">
    <link href="css/dataTables/dataTables.responsive.css" rel="stylesheet">
    <link href="css/dataTables/dataTables.tableTools.min.css" rel="stylesheet">
<!-- 本地包 -->
    <link rel="stylesheet" type="text/css" href="css/w.css">

</head>
<body>
<%@ include file="/WEB-INF/jsp/public/title.jspf"%>
    <div style="margin:100px auto;width:1200px;">
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <div class="row"></div>
                        <h5 class="col-lg-1">用户列表</h5>
                    <div>
                    <a href="user_addUI.action"><button type="button" class="btn btn-primary btn-sm" style="margin-top:-5px;float:right">添加用户</button></a>
                </div>
            </div>
            <s:form action="user_list.action">
                <div style="display:inline;width:200px;float:right;margin:10px 80px -100px 0;">
                    <input name="name" type="text" placeholder="姓名" class="form-control">
                </div>
                <div style="display:inline;width:200px;float:right;margin:10px 290px -100px 0;">
                    <input name="phone" type="text" placeholder="电话" class="form-control">
                </div>
                <div style="display:inline;width:50px;float:right;margin:10px 20px -100px 0;">
                    <button id="w-create-submit" type="submit" class="btn btn-primary"
                            style="float:left">搜索
                    </button>
                </div>
            </s:form>
            <div class="ibox-content">
                <table class="table table-striped table-bordered table-hover dataTables-example">
                <thead>
                <div class="row">
                    <tr>
                        <th>昵称</th>
                        <th>姓名</th>
                        <th>电话</th>
                        <th>操作</th>
                    </tr>
                </div>
                </thead>
                <tbody>
                <s:iterator value="beans" status="st">
                    <tr>
                        <td>${loginName}</td>
                        <td>${name}</td>
                        <td>${phone}</td>
                        <td>
                            <s:a action="user_delete?id=%{id}" class="edit">删除</s:a>
                            <s:a action="user_edit?id=%{id}" class="edit">重置密码</s:a>
                        </td>
                    </tr>
                </s:iterator>
                </tbody>
                </table>
            </div>
        </div>
    </div>



<!-- 基础包 -->
<script src="js/jquery-1.10.2.js"></script>
<script src="js/bootstrap.min.js"></script>


<!-- Data Tables -->
<script src="js/dataTables/jquery.dataTables.js"></script>
<script src="js/dataTables/dataTables.bootstrap.js"></script>
<script src="js/dataTables/dataTables.responsive.js"></script>
<script src="js/dataTables/dataTables.tableTools.min.js"></script>

<!-- 本地包 -->

<script src="js/001.js"></script>
<script>

    $(function () {
        $('.dataTables-example').dataTable(
                {"searching": false}
        );
    });

</script>
</body>
</html>    