<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <title>meeks</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/w.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/public/title.jspf"%>
<div class="m-main">
    <div class="row">
        <a href="house_list.action">
            <div class="col-lg-3 m-main-top">
                <div class="m-main-top-2 m-main-top-all">
                    <p>包房管理</p>
                </div>
            </div>
        </a>
        <a href="vip_list.action">
            <div class="col-lg-3 m-main-top">
                <div class="m-main-top-3 m-main-top-all">
                    <p>会员管理</p>
                </div>
            </div>
        </a>
        <a href="bill_list.action">
            <div class="col-lg-3 m-main-top">
                <div class="m-main-top-4 m-main-top-all">
                    <p>账单管理</p>
                </div>
            </div>
        </a>
        <a href="reserve_list.action">
            <div class="col-lg-3 m-main-top">
                <div class="m-main-top-1 m-main-top-all">
                    <p>预约列表</p>
                </div>
            </div>
        </a>


        <a href="user_list.action">
            <div class="col-lg-3 m-main-top" style="margin-left: 12.5%">
                <div class="m-main-top-4 m-main-top-all">
                    <p>用户管理</p>
                </div>
            </div>
        </a>
        <a href="bill_list.action">
            <div class="col-lg-3 m-main-top" style="margin-left: 25%">
                <div class="m-main-top-4 m-main-top-all">
                    <p>账单管理</p>
                </div>
            </div>
        </a>
    </div>
</div>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/001.js"></script>
</body>
</html>    

