<%@ page contentType="text/html;charset=UTF-8" language="java"
isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<html>
<head>
    <title>登录</title>
    <%--    <script src="js/jquery/2.0.0/jquery.min.js"></script>--%>
    <script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <link   href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">

    <style type="text/css">
        <%--body{--%>
        <%--    background: url(${ctx}/images/a.jpg)repeat;--%>
        <%--}--%>

        #login-box {
            padding: 35px;
            border-radius:15px;
            background: #56666B;
            color: #fff;
        }

    </style>
</head>
<body>
<div class="container" id="top">
    <div class="row" style="margin-top: 280px; ">
        <div class="col-md-4"></div>
        <div class="col-md-4" id="login-box">
            <h2>智能学习系统</h2>
            <div></div>
            <form class="form-horizontal" role="form" action="/login" id="from1" method="post">
                <div class="form-group">
                    <label class="col-sm-3 control-label">名称：</label>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" placeholder="请输入登录名" name="name">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">密码：</label>
                    <div class="col-sm-9">
                        <input type="password" class="form-control" id="password" placeholder="请输入密码" name="password">
                    </div>
                </div>

                <div class="form-group pull-right" style="margin-right: 15px;">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default btn-info">登录</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
</body>
</html>
