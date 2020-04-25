<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/14
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="../include/taglib.jsp" %>
<html>
<head>
    <title>学生列表</title>

    <link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet" type="text/css">

    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <script src="js/bootstrap/3.3.6/bootstrap.js"></script>


</head>
<body>


<%--顶栏--%>
<jsp:include page="../include/teacher/top.jsp"/>

<%--主体--%>
<div class="container" id="content">
    <div class="row">
        <%--侧边栏--%>
        <jsp:include page="../include/teacher/menu.jsp"/>

        <div class="col-md-10">

            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 class="col-md-5">学生列表</h1>
                        <form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" action="teacher_selectStudent" id="form1" method="post">
                            <div class="input-group">
                                <%--搜索栏功能--%>
                                <input type="text" class="form-control" placeholder="请输入名字" name="name">
                                <span class="input-group-addon btn" id="sub" onclick="">搜索</span>
                            </div>
                        </form>
                    </div>
                </div>

                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>学生</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${studentList}" var="student">
                        <tr>
                            <td>${student.name}</td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info"
                                        onClick="location.href='teacher_listMastery'">查看掌握程度
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <%--分页--%>
<%--                <div id="pageDiv" class="text-center">--%>
<%--                    <ul class="pagination">--%>
<%--                        <li>--%>
<%--                            <a href="?start=0">&laquo;</a>--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <a href="?start=${page.start-page.count}">&lsaquo;</a>--%>
<%--                        </li>--%>

<%--                        &lt;%&ndash;        <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">&ndash;%&gt;--%>
<%--                        &lt;%&ndash;            <li>&ndash;%&gt;--%>
<%--                        &lt;%&ndash;                <a href="?start=${status.index*page.count}">${status.count}</a>&ndash;%&gt;--%>
<%--                        &lt;%&ndash;            </li>&ndash;%&gt;--%>
<%--                        &lt;%&ndash;        </c:forEach>&ndash;%&gt;--%>

<%--                        <li>--%>
<%--                            <a href="?start=${page.start+page.count}">&rsaquo;</a>--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <a href="?start=${page.last}">&raquo;</a>--%>
<%--                        </li>--%>
<%--                    </ul>--%>
<%--                </div>--%>
            </div>

        </div>
    </div>
</div>

<script type="text/javascript">
    /*改变侧边栏当前选项卡样式*/
    $("#nav li:nth-child(2)").addClass("active");
</script>
</body>
</html>
