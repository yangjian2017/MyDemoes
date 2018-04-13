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
    <title>记录展示</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-md8 layui-col-md-offset2 layui-col-xs10 layui-col-xs-offset1">
            <textarea name="text" class="layui-textarea" readonly id="text" hidden style="width: 624px"></textarea>
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-col-md9 layui-col-md-offset2 layui-col-xs12 layui-bg-gray" id="images" style="height: auto;width: 624px">

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
        jq.get("/record/getLastRecord", function (res) {
            if (res.code == "0") {
                var record = res.data;

                var text = record.text;
                jq("#text").val(text).show();

                var div = "";
                var images = record.images.split(',');
                for (var i in images) {
                    var index = parseInt(i) + 1;
                    if (!images[i]) {
                        continue;
                    }
                    div += '' +
                        '<div style="width: 200px;height:200px;float: left;margin: 3px 2px;border-radius: 2px;border: solid 2px">' +
                        '   <a href="' + images[i] + '" target="_blank"><img src="' + images[i] + '" alt="图片' + (index) + '" style="max-height: 100%;max-width: 100%;"></a>' +
                        '</div>';

                }
                jq("#images").html(div);
            }
        });
    })
</script>
</html>
