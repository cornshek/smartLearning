<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/4/16
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>发生错误</title>

    <link   href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet" type="text/css">

    <script src="js/jquery/2.0.0/jquery.min.js"></script>
    <script src="js/bootstrap/3.3.6/bootstrap.js"></script>
</head>
<body>
<div class="container" id="content">
    <div class="row">
        <div class="col-md">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 style="text-align: center;">错误！</h1>
                        <h2 style="text-align: center;">${message}</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
