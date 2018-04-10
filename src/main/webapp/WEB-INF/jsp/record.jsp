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
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div class="layui-container layui-bg-orange">
    <div class="layui-row">
        <div class="layui-col-md8 layui-col-md-offset2 layui-col-xs10 layui-col-xs-offset1 layui-bg-gray">
            <textarea name="text" class="layui-textarea" readonly id="text" hidden></textarea>
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-col-md9 layui-col-md-offset2 layui-col-xs12 layui-bg-gray" id="images">

        </div>
    </div>
</div>
</div>
</body>
<script src="layui/layui.js"></script>
<script>
    layui.use(['layer'], function () {
        var layer = layui.layer;
        var jq = layui.$;
        jq.get("/record/getLastRecord",function (res) {
            if (res.code == "0"){
                var record = res.data;

                var text = record.text;
                jq("#text").val(text).show();

                var div;
                var images = record.images;
                for (var img in images){
                    div += '' +
                        '<div class="layui-col-md2 layui-col-md-offset1 layui-col-xs3 layui-col-xs-offset1 layui-bg-gray">' +
                        '   <img src="'+img+'" alt="图片">' +
                        '</div>';

                }
                jq("#images").html(div);
            }
        });
    })
</script>
</html>
