<%--
  Created by IntelliJ IDEA.
  User: yangjian
  Date: 2018/3/30
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>引导页</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
<button class="layui-btn-primary" id="clickMe">点我</button>
</body>
<script src="layui/layui.js"></script>
<script>

    layui.use("layer", function () {

        var layer = layui.layer;
        var jq = layui.$;
        jq("#clickMe").click(function () {
            layer.msg("你好");
            location.href = "/user/hello";
        });
    })
</script>
</html>
