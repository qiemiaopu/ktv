<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <title>包房信息</title>


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
                <div class="ibox-title">
                    <div class="row"></div>
                    <h5 class="col-lg-1">包房列表</h5>
                    <div>
                        <a href="house_addUI.action">
                            <button type="button" class="btn btn-primary btn-sm" style="margin-top:-5px;float:right">
                                添加包房
                            </button>
                        </a>
                    </div>
                </div>
                <s:form action="house_list.action">
                    <div style="display:inline;width:200px;float:right;margin:10px 80px -100px 0;">
                        <s:select id="status" name="status"
                                  list="#{-1:'所有状态', 0:'可使用',1:'使用中',2:'快到期',3:'打扫中',4:'被预定'}"
                                  class="form-control"/>
                    </div>
                    <div style="display:inline;width:200px;float:right;margin:10px 290px -100px 0;">
                        <s:select id="type" name="type"
                                  list="#{0:'所有类型', 1:'小包', 2:'中包', 3:'大包', 4:'豪包'}"
                                  class="form-control"/>
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
                                <th>包房</th>
                                <th>类型</th>
                                <th>价格/小时</th>
                                <th>状态</th>
                                <th>折扣</th>
                                <th>开始时间</th>
                                <th>结束时间</th>
                                <th>操作记录</th>
                                <th>操作</th>
                            </tr>
                        </div>
                        </thead>
                        <tbody>
                        <s:iterator value="beans" status="st">
                            <tr>
                                <td>${name}</td>
                                <td>${type=='1'?"小包":type=='2'?"中包":type=='3'?"大包":"豪包"}</td>
                                <td>${value}</td>
                                <td ${status=='0'?"bgColor=#b4ffb4":status=='1'?"bgColor=#b4b4ff":status=='2'?"bgColor=#ffb4b4":status=='3'?"bgColor=#ffffb4":"bgColor=#b4ffff"}>${status=='0'?"可使用":status=='1'?"使用中":status=='2'?"快到期":status=='3'?"打扫中":"被预定"}</td>
                                <td>${discount}</td>
                                <td><s:date name="startTime" format="MM月dd日HH时mm分"/></td>
                                <td><s:date name="endTime" format="MM月dd日HH时mm分"/></td>
                                <td>${action1}</td>
                                <td>
                                    <s:if test="status eq 0">
                                        <%--开台--%>
                                        <span style="margin-right:15px;margin-left:15px"><s:a
                                                action="house_handleUI.action?id=%{id}&status=1"
                                                class="edit"><i
                                                class="fa fa-home"></i></s:a></span>
                                        <s:if test="#session.user.isAdmin()">
                                            <%--删除--%>
                                        <span style="margin-right:15px;"><s:a action="house_delete?id=%{id}"
                                                                              class="edit"><i
                                                class="fa fa-trash-o"></i></s:a></span>
                                            <%--修改--%>
                                        <span style="margin-right:15px;"><s:a action="house_editUI?id=%{id}"
                                                                              class="edit"><i
                                                class="fa fa-pencil"></i></s:a></span>
                                        </s:if>
                                        <%--预约--%>
                                        <span style="margin-right:15px;"><s:a action="reserve_addUI?houseId=%{id}"
                                                                              class="edit">预约</s:a></span>
                                    </s:if>
                                    <s:if test="status == 1">
                                        <s:a action="house_handleUI?id=%{id}&status=5" class="edit">续费</s:a>
                                        <s:a action="house_handle?id=%{id}&status=3" class="edit">清理</s:a>
                                    </s:if>
                                    <s:if test="status == 3">
                                        <s:a action="house_handle?id=%{id}&status=0" class="edit">清理完</s:a>
                                    </s:if>
                                    <s:if test="status == 4">
                                        <s:a action="reserve_show?id=%{reserveId}" class="edit">预约信息</s:a>
                                        <s:a action="house_deleteReserve?id=%{id}" class="edit"> 删除预约</s:a>
                                    </s:if>
                                </td>
                            </tr>
                        </s:iterator>
                        </tbody>
                    </table>
                </div>
            </div>
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