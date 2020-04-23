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
    <title>英语单词记忆</title>

    <link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet" type="text/css">

    <%--引入答题插件css--%>
    <link href="css/answer/style.css" rel="stylesheet" type="text/css"/>

    <style type="text/css">
        .demo{}
    </style>

    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <script src="js/bootstrap/3.3.6/bootstrap.js"></script>

    <%--引入答题插件--%>
    <script type="text/javascript" src="js/answer/quiz.js"></script>


    <script>
        var questions = ${jsonString};
        // var init={'questions': [
        //         {'question':'我是单词','answers':['我是中文','我是中文','我是中文','我是中文'],'correctAnswer':1},
        //         {'question':'我是单词','answers':['我是中文','我是中文','我是中文','我是中文'],'correctAnswer':1}
        //     ]};
        var init={'questions': questions};

        $(function(){
            $('#quiz-container').jquizzy({
                questions: init.questions
            });
        });
    </script>

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
                        <h1 class="col-md-5">英语单词记忆</h1>
                    </div>
                </div>

                <%--答题插件--%>
                <div class="demo">
                    <div id='quiz-container'></div>
                    <div style="clear: both"></div>
                </div>

                <table>
                    <tr id="again" style="display: none">
                        <td>
                            <button class="btn btn-default btn-xs btn-info" style="padding: 1px 67px; font-size: 50px; background-color: #555; border-color: white" onClick="location.href='student_memorizeWord?number=5'">再来5个
                            <button class="btn btn-default btn-xs btn-info" style="padding: 1px 53px; font-size: 50px; background-color: #555; border-color: white" onClick="location.href='student_memorizeWord?number=10'">再来10个
                            <button class="btn btn-default btn-xs btn-info" style="padding: 1px 54px; font-size: 50px; background-color: #555; border-color: white" onClick="location.href='student_memorizeWord?number=20'">再来20个
                            <%--用不闭合标签的方式解决按钮间空隙的问题--%>
                        </td>
                    </tr>
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