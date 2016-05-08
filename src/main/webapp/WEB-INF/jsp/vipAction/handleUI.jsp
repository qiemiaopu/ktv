<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <title>包房</title>

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
<div style="margin:100px auto;width:800px;">
    <div class="row">
        <div class="col-lg-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <div class="row">
                        <h5 style="margin:0 0 10px 15px;"><b>开房</b>
                        </h5>
                    </div>
                    <div class="ibox-content">
                        <s:form id="w-create-manage-form" action="house_handle.action" cssClass="form-horizontal">
                            <s:hidden name="id"></s:hidden>
                            <s:hidden name="status"></s:hidden>
                            <div class="form-group">
                                <label class="col-lg-1 control-label">包房</label>
                                <div class="col-lg-11">
                                    <s:textfield name="name" cssClass="form-control" disabled="true"/>
                                    <span class="help-block m-b-none"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-1 control-label">类型</label>
                                <div class="col-lg-11">
                                    <s:select id="type" name="type" disabled="true"
                                              list="#{1:'小包', 2:'中包', 3:'大包', 4:'豪包'}"
                                              class="form-control"/>
                                    <span class="help-block m-b-none"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-1 control-label">价格</label>
                                <div class="col-lg-11">
                                    <s:textfield name="value" cssClass="form-control" disabled="true"/>
                                    <span class="help-block m-b-none"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-1 control-label">折扣</label>
                                <div class="col-lg-11">
                                    <s:textfield name="discount" cssClass="form-control" disabled="true"/>
                                    <span class="help-block m-b-none"></span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-lg-1 control-label">时长</label>
                                <div class="col-lg-11">
                                    <s:textfield name="hours" cssClass="form-control" disabled="false"/>
                                    <span class="help-block m-b-none"></span>
                                </div>
                            </div>
                            <!-- 第一组按钮 -->
                            <div class="form-group">
                                <div class="col-lg-6 col-lg-offset-1">
                                    <button id="w-create-submit" type="submit" class="btn btn-primary"
                                            style="float:left">保存设置
                                    </button>
                                    <button id="w-create-cancel" type="reset" class="btn btn-default"
                                            style="float:left">取消设置
                                    </button>
                                </div>
                            </div>
                        </s:form>
                        <%--</form>--%>
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