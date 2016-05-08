<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <title>会员信息</title>


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
                    <h5 class="col-lg-1">包房列表</h5>
                    <div>
                        <a href="vip_addUI.action">
                            <button type="button" class="btn btn-primary btn-sm" style="margin-top:-5px;float:right">
                                新增会员卡
                            </button>
                        </a>
                    </div>
                </div>
                <s:form action="vip_list.action">
                    <div style="display:inline;width:200px;float:right;margin:10px 290px -100px 0;">
                        <input name="number" type="text" placeholder="卡号" class="form-control">
                    </div>
                    <div style="display:inline;width:200px;float:right;margin:10px 80px -100px 0;">
                        <input name="owner" type="text" placeholder="姓名" class="form-control">
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
                                <th>卡号</th>
                                <th>余额</th>
                                <th>卡主姓名</th>
                                <th>卡主电话</th>
                                <th>出售时间</th>
                                <th>操作</th>
                            </tr>
                        </div>
                        </thead>
                        <tbody>
                        <s:iterator value="beans" status="st">
                            <tr>
                                <td>${number}</td>
                                <td>${value}</td>
                                <td>${owner}</td>
                                <td>${phone}</td>
                                <td><s:date name="createTime" format="MM月dd日HH时mm分"/></td>
                                <td>
                                    <s:if test="createTime != ''">
                                        <s:a action="vip_buyUI.action?id=%{id}" class="edit">售卡</s:a>
                                        <s:a action="vip_delete.action?id=%{id}" class="edit">删除</s:a>
                                    </s:if>
                                    <%--<s:if test="status eq 0">--%>
                                        <%--&lt;%&ndash;开台&ndash;%&gt;--%>
                                        <%--<span style="margin-right:15px;margin-left:15px"><s:a--%>
                                                <%--action="house_handleUI.action?id=%{id}&status=1"--%>
                                                <%--class="edit"><i--%>
                                                <%--class="fa fa-home"></i></s:a></span>--%>
                                        <%--&lt;%&ndash;删除&ndash;%&gt;--%>
                                        <%--<span style="margin-right:15px;"><s:a action="house_delete?id=%{id}" class="edit"><i--%>
                                                <%--class="fa fa-trash-o"></i></s:a></span>--%>
                                        <%--&lt;%&ndash;修改&ndash;%&gt;--%>
                                        <%--<span style="margin-right:15px;"><s:a action="house_editUI?id=%{id}" class="edit"><i--%>
                                                <%--class="fa fa-pencil"></i></s:a></span>--%>
                                    <%--</s:if>--%>
                                    <%--<s:if test="status == 1">--%>
                                        <%--<s:a action="house_handleUI?id=%{id}&status=5" class="edit">续费</s:a>--%>
                                        <%--<s:a action="house_handle?id=%{id}&status=3" class="edit">清理</s:a>--%>
                                    <%--</s:if>--%>
                                    <%--<s:if test="status == 3">--%>
                                        <%--<s:a action="house_handle?id=%{id}&status=0" class="edit">清理完</s:a>--%>
                                    <%--</s:if>--%>
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