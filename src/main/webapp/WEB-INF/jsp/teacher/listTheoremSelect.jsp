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
    <title>数学定理</title>

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
                        <h1 class="col-md-5">定理列表</h1>
                        <form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" action="teacher_selectTheorem" id="form1" method="post">
                            <div class="input-group">
                                <%--搜索栏功能--%>
                                <input type="text" class="form-control" placeholder="请输入定理名称" name="name">
                                <span class="input-group-addon btn" id="sub" onclick="$('#form1').submit">搜索</span>
                            </div>
                        </form>
                    </div>
                </div>

                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>定理名称</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${theorems}" var="theorem">
                        <tr>
                            <td>${theorem.name}</td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info"
                                        onClick="location.href='teacher_addTest?knowledge=${theorem.name}'">添加试题
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <%--TODO 分页暂时不做--%>
<%--                <div class="panel-footer">--%>
<%--                    <c:if test="${pagingVO != null}">--%>
<%--                        <nav style="text-align: center">--%>
<%--                            <ul class="pagination">--%>
<%--                                <li><a href="${ctx}/student/showCourse?page=${pagingVO.upPageNo}">&laquo;上一页</a></li>--%>
<%--                                <li class="active"><a href="">${pagingVO.curentPageNo}</a></li>--%>
<%--                                <c:if test="${pagingVO.curentPageNo+1 <= pagingVO.totalCount}">--%>
<%--                                    <li>--%>
<%--                                        <a href="${ctx}/student/showCourse?page=${pagingVO.curentPageNo+1}">${pagingVO.curentPageNo+1}</a>--%>
<%--                                    </li>--%>
<%--                                </c:if>--%>
<%--                                <c:if test="${pagingVO.curentPageNo+2 <= pagingVO.totalCount}">--%>
<%--                                    <li>--%>
<%--                                        <a href="${ctx}/student/showCourse?page=${pagingVO.curentPageNo+2}">${pagingVO.curentPageNo+2}</a>--%>
<%--                                    </li>--%>
<%--                                </c:if>--%>
<%--                                <c:if test="${pagingVO.curentPageNo+3 <= pagingVO.totalCount}">--%>
<%--                                    <li>--%>
<%--                                        <a href="${ctx}/student/showCourse?page=${pagingVO.curentPageNo+3}">${pagingVO.curentPageNo+3}</a>--%>
<%--                                    </li>--%>
<%--                                </c:if>--%>
<%--                                <c:if test="${pagingVO.curentPageNo+4 <= pagingVO.totalCount}">--%>
<%--                                    <li>--%>
<%--                                        <a href="${ctx}/student/showCourse?page=${pagingVO.curentPageNo+4}">${pagingVO.curentPageNo+4}</a>--%>
<%--                                    </li>--%>
<%--                                </c:if>--%>
<%--                                <li><a href="${ctx}/student/showCourse?page=${pagingVO.totalCount}">最后一页&raquo;</a></li>--%>
<%--                            </ul>--%>
<%--                        </nav>--%>
<%--                    </c:if>--%>
<%--                </div>--%>
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
