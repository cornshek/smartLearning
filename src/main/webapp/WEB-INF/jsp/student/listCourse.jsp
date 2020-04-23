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
    <title>课程列表</title>

    <link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet" type="text/css">

    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <script src="js/bootstrap/3.3.6/bootstrap.js"></script>

</head>
<body>


<%--顶栏--%>
<jsp:include page="../include/student/top.jsp"/>

<%--主体--%>
<div class="container" id="content">
    <div class="row">
        <%--侧边栏--%>
        <jsp:include page="../include/student/menu.jsp"/>

        <div class="col-md-10">

            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 class="col-md-5">课程列表</h1>
                    </div>
                </div>

                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>学科</th>
                        <th>记忆数量</th>
                    </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>英语单词</td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info"
                                        onClick="location.href='student_memorizeWord?number=5'">five
                                </button>
                                <button class="btn btn-default btn-xs btn-info"
                                        onClick="location.href='student_memorizeWord?number=10'">ten
                                </button>
                                <button class="btn btn-default btn-xs btn-info"
                                        onClick="location.href='student_memorizeWord?number=20'">twenty
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td>数学公式/定理</td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info"
                                        onClick="location.href='student_memorizeTheorem?number=5'">V
                                </button>
                                <button class="btn btn-default btn-xs btn-info"
                                        onClick="location.href='student_memorizeTheorem?number=10'">X
                                </button>
                                <button class="btn btn-default btn-xs btn-info"
                                        onClick="location.href='student_memorizeTheorem?number=20'">XX
                                </button>
                            </td>
                        </tr>
                        <tr>
                            <td>古诗</td>
                            <td>
                                <button class="btn btn-default btn-xs btn-info"
                                        onClick="location.href='student_memorizeWord?number=5'">伍
                                </button>
                                <button class="btn btn-default btn-xs btn-info"
                                        onClick="location.href='student_memorizeWord?number=10'">拾
                                </button>
                                <button class="btn btn-default btn-xs btn-info"
                                        onClick="location.href='student_memorizeWord?number=20'">贰拾
                                </button>
                            </td>
                        </tr>
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
