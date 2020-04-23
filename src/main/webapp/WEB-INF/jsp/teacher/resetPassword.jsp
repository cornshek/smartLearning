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
    <title>修改密码</title>

    <link   href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet" type="text/css">

    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <script src="js/bootstrap/3.3.6/bootstrap.js"></script>

    <script>

        /*监听表单提交*/
        function check() {
            var oldPassword = $("#editForm input[name='oldPassword']").val();
            var password1 = $("#editForm input[name='password1']").val();
            var password2 = $("#editForm input[name='password2']").val();

            if (oldPassword === "" || oldPassword === null) {
                alert("请输入旧密码");
                return false;
            }
            if (password1 === "" || password1 === null) {
                alert("请输入新密码");
                return false;
            }
            if (password2 === "" || password2 === null) {
                alert("请再次输入新密码");
                return false;
            }
            if (password1 !== password2) {
                alert("请保持两次新输入密码一致");
                return false;
            }
        }
    </script>
</head>
<body>
<%--顶栏--%>
<jsp:include page="../include/teacher/top.jsp"/>

<div class="container" id="content">
    <div class="row">
        <%--侧边栏--%>
        <jsp:include page="../include/teacher/menu.jsp"/>

            <div class="col-md-10">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="row">
                            <h1 style="text-align: center;">修改密码</h1>
                        </div>
                    </div>
                    <div class="panel-body">
                        <form name="reset" class="form-horizontal" role="form" action="resetPassword" id="editForm" method="post" onsubmit="return check()">
                            <div class="form-group">
                                <label for="inputEmail3" class="col-sm-2 control-label">旧密码</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="oldPassword" id="inputEmail3" placeholder="请输入旧密码" >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">新密码</label>
                                <div class="col-sm-10">
                                    <input type="password" name="password1" class="form-control" placeholder="请输入密码">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">确认密码</label>
                                <div class="col-sm-10">
                                    <input type="password" name="password2" class="form-control" placeholder="请再次输入密码">
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
