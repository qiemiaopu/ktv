<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <title>预约信息</title>


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
<%@ include file="/WEB-INF/jsp/public/title.jspf" %>
<div style="margin:100px auto;width:1200px;">
    <div class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-content">
                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <div class="row">
                            <tr>
                                <th>预约人</th>
                                <th>电话</th>
                                <th>开始时间</th>
                                <th>结束时间</th>
                            </tr>
                        </div>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${name}</td>
                            <td>${phone}</td>
                            <td><s:date name="startTime" format="MM月dd日HH时mm分"/></td>
                            <td><s:date name="endTime" format="MM月dd日HH时mm分"/></td>
                        </tr>
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
    </div>
</div>
</body>
</html>    