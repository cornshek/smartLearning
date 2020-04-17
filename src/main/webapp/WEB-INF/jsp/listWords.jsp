<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/10
  Time: 0:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>


<html>
<head>
    <title>查看所有单词</title>
<%--    <script src="js/jquery/2.0.0/jquery.min.js"></script>--%>
    <script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <link   href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">


</head>
<body>
<table align="center" class="table-striped table-bordered table-hover table-condensed">
    <c:forEach items="${enWordsList}" var="enWordsList">
        <tr>
            <td>${enWordsList.word}</td>
            <td>${enWordsList.translation}</td>
        </tr>
    </c:forEach>
</table>

<%--分页--%>
<div class="text-center">
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
</body>
</html>
