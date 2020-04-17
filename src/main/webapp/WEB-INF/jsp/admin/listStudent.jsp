<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/14
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@include file="../include/taglib.jsp"%>
<html>
<head>
    <title>学生管理</title>

    <link   href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet" type="text/css">

    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <script src="js/bootstrap/3.3.6/bootstrap.js"></script>
</head>
<body>
<script>
    function checkConfirm() {
        var msg = "您真的确定要删除吗？！";
        if (confirm(msg)==true){
            return true;
        }else{
            return false;
        }
    }
</script>

    <%--顶栏--%>
    <jsp:include page="../include/admin/top.jsp"/>

    <%--主体--%>
    <div class="container" id="content">
        <div class="row">
            <%--侧边栏--%>
            <jsp:include page="../include/admin/menu.jsp"/>

                <div class="col-md-10">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="row">
                                <h1 class="col-md-5">学生管理</h1>
                                <form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" action="admin_selectStudent" id="form1" method="post">
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="请输入姓名" name="name">
                                        <span class="input-group-addon btn" id="sub">搜索</span>
                                    </div>
                                </form>
                                <button class="btn btn-default col-md-2" style="margin-top: 20px" onClick="location.href='admin_addStudent'">
                                    添加学生信息
                                    <sapn class="glyphicon glyphicon-plus"/>
                                </button>

                            </div>
                        </div>

                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>学号</th>
                                <th>姓名</th>
                                <th>性别</th>
                                <th>出生日期</th>
                                <th>注册日期</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach  items="${studentList}" var="item">
                                <tr>
                                    <td>${item.id}</td>
                                    <td>${item.name}</td>
                                    <td>${item.sex}</td>
                                    <td><fmt:formatDate value="${item.birthday}" dateStyle="medium" /></td>
                                    <td><fmt:formatDate value="${item.registerTime}" dateStyle="medium" /></td>
                                    <td>
                                        <button class="btn btn-default btn-xs btn-info" onClick="location.href='admin_editStudent?id=${item.id}'">修改</button>
                                        <a class="btn btn-danger btn-xs" href="admin_deleteStudent?id=${item.id}" onclick="return checkConfirm()">删除</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
<%--                        <div class="panel-footer">--%>
<%--                            <c:if test="${pagingVO != null}">--%>
<%--                                <nav style="text-align: center">--%>
<%--                                    <ul class="pagination">--%>
<%--                                        <li><a href="${ctx}/admin/showStudent?page=${pagingVO.upPageNo}">&laquo;上一页</a></li>--%>
<%--                                        <li class="active"><a href="">${pagingVO.curentPageNo}</a></li>--%>
<%--                                        <c:if test="${pagingVO.curentPageNo+1 <= pagingVO.totalCount}">--%>
<%--                                            <li><a href="${ctx}/admin/showStudent?page=${pagingVO.curentPageNo+1}">${pagingVO.curentPageNo+1}</a></li>--%>
<%--                                        </c:if>--%>
<%--                                        <c:if test="${pagingVO.curentPageNo+2 <= pagingVO.totalCount}">--%>
<%--                                            <li><a href="${ctx}/admin/showStudent?page=${pagingVO.curentPageNo+2}">${pagingVO.curentPageNo+2}</a></li>--%>
<%--                                        </c:if>--%>
<%--                                        <c:if test="${pagingVO.curentPageNo+3 <= pagingVO.totalCount}">--%>
<%--                                            <li><a href="${ctx}/admin/showStudent?page=${pagingVO.curentPageNo+3}">${pagingVO.curentPageNo+3}</a></li>--%>
<%--                                        </c:if>--%>
<%--                                        <c:if test="${pagingVO.curentPageNo+4 <= pagingVO.totalCount}">--%>
<%--                                            <li><a href="${ctx}/admin/showStudent?page=${pagingVO.curentPageNo+4}">${pagingVO.curentPageNo+4}</a></li>--%>
<%--                                        </c:if>--%>
<%--                                        <li><a href="${ctx}/admin/showStudent?page=${pagingVO.totalCount}">最后一页&raquo;</a></li>--%>
<%--                                    </ul>--%>
<%--                                </nav>--%>
<%--                            </c:if>--%>
<%--                        </div>--%>
                    </div>

                </div>
        </div>
    </div>


</body>
</html>
