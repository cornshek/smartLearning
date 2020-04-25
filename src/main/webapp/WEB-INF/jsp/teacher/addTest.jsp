<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/16
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>添加试题</title>

    <link   href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet" type="text/css">

    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <script src="js/bootstrap/3.3.6/bootstrap.js"></script>
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
                            <h1 style="text-align: center;">添加试题</h1>
                        </div>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" action="teacher_addTest" id="editForm" method="post">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">题干</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="question" placeholder="请输入题干">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">答案</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="answer" placeholder="请输入答案">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">混淆项1</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="confusion1" placeholder="请输入混淆项，可为空">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">混淆项2</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="confusion2" placeholder="请输入混淆项，可为空">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">混淆项3</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="confusion3" placeholder="请输入混淆项，可为空">
                                    <input type="hidden" name="knowledge" value="${knowledge}">
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
    $("#nav li:nth-child(1)").addClass("active");
</script>
</body>
</html>
