<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/16
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="../include/taglib.jsp"%>
<html>
<head>
    <title>修改教师信息</title>

    <link   href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet" type="text/css">

    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <script src="js/bootstrap/3.3.6/bootstrap.js"></script>
</head>
<body>
<%--顶栏--%>
<jsp:include page="../include/admin/top.jsp"/>

<div class="container" id="content">
    <div class="row">
        <%--侧边栏--%>
        <jsp:include page="../include/admin/menu.jsp"/>

            <div class="col-md-10">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="row">
                            <h1 style="text-align: center;">修改教师信息</h1>
                        </div>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" action="admin_editTeacher" id="editForm" method="post">
                            <input type="hidden" name="id" value="${teacher.id}"/>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">姓名</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="name" value="${teacher.name}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">性别</label>
                                <div class="col-sm-10">
                                    <label class="checkbox-inline">
                                        <input type="radio" name="sex" value="男">男
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="radio" name="sex" value="女">女
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">出生日期</label>
                                <div class="col-sm-10">
                                    <input type="date" class="form-control" name="birthday" value="<fmt:formatDate value="${teacher.birthday}" dateStyle="medium" pattern="yyyy-MM-dd" />"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">注册日期</label>
                                <div class="col-sm-10">

                                    <input type="date" class="form-control" readonly="true" name="registerTime" value="<fmt:formatDate value="${teacher.registerTime}" dateStyle="medium" pattern="yyyy-MM-dd" />"/>
                                </div>
                            </div>
                            <div class="form-group" style="text-align: center">
                                <button class="btn btn-default" type="submit">提交</button>
                                <button class="btn btn-default" type="reset">重置</button>
                            </div>
                        </form>
                    </div>

                </div>

            </div>
    </div>
</div>

<script type="text/javascript">
    /*改变侧边栏当前选项卡样式*/
    $("#nav li:nth-child(3)").addClass("active");
</script>
</body>
</html>
