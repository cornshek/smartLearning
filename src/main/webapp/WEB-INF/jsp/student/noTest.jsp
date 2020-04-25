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
    <title>习题实战</title>

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
        //         {'question':'我是单词','answers':['我是中文','我是中文','我是中文'],'correctAnswer':1},
        //         {'question':'我是单词','answers':['我是中文','我是中文','我是中文','我是中文'],'correctAnswer':1}
        //     ]};
        var init={'questions': questions};

        $(function(){
            $('#quiz-container').jquizzy({
                questions: init.questions
            });
        });

        /*Ajax 计算掌握度*/
        var xmlHttp;
        function check(){
            var results = document.getElementById("results").value;
            var url = "calMastery";

            xmlHttp =new XMLHttpRequest();
            //响应函数
            xmlHttp.onreadystatechange=checkResult;
            //设置访问的页面
            xmlHttp.open("POST",url,true);
            //因为是POST 需要设置消息头
            xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            //执行访问，传递参数
            xmlHttp.send("results=" + results + "&questions=" + JSON.stringify(questions));
        }

        function checkResult(){
            if (xmlHttp.readyState===4 && xmlHttp.status===200){
                var callback = JSON.parse(xmlHttp.responseText);
                document.getElementById('finish').innerHTML = callback.result;
            }
        }
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
                        <h1 class="col-md-5">目前没有习题</h1>
                    </div>
                </div>





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
    $("#nav li:nth-child(2)").addClass("active");
</script>
</body>
</html>
