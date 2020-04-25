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
    <title>知识点掌握程度</title>

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
                        <h1 class="col-md-5">知识点掌握程度</h1>
<%--                        <form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" action="teacher_selectMastery" id="form1" method="post">--%>
<%--                            <div class="input-group">--%>
<%--                                &lt;%&ndash;搜索栏功能&ndash;%&gt;--%>
<%--                                <input type="text" class="form-control" placeholder="请输入名字" name="knowledge">--%>
<%--                                <span class="input-group-addon btn" id="sub" onclick="">搜索</span>--%>
<%--                            </div>--%>
<%--                        </form>--%>
                    </div>
                </div>

                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>知识点</th>
                        <th>掌握度</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${masteryList}" var="mastery">
                        <tr>
                            <td>${mastery.knowledge}</td>
                            <td>${mastery.value}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <%--分页--%>
                <div id="pageDiv" class="text-center">
                    <ul class="pagination">
                        <li>
                            <a href="?start=0">&laquo;</a>
                        </li>
                        <li>
                            <a href="?start=${page.start-page.count}">&lsaquo;</a>
                        </li>

                        <%--        <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">--%>
                        <%--            <li>--%>
                        <%--                <a href="?start=${status.index*page.count}">${status.count}</a>--%>
                        <%--            </li>--%>
                        <%--        </c:forEach>--%>

                        <li>
                            <a href="?start=${page.start+page.count}">&rsaquo;</a>
                        </li>
                        <li>
                            <a href="?start=${page.last}">&raquo;</a>
                        </li>
                    </ul>
                </div>
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
