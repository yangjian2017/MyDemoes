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
    <title>首页</title>
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
        <div class="layui-col-md8 layui-col-md-offset2 layui-col-xs10 layui-col-xs-offset1 layui-bg-gray">
            <form class="layui-form" action="/record/save" method="post">
                <input type="hidden" name="images" id="images">
                <div class="layui-form-item">
                    <%--<label class="layui-form-label">文本域</label>--%>
                    <div class="layui-input-block">
                        <textarea name="text" placeholder="请输入内容" class="layui-textarea"
                                  style="width: 612px"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block" id="img-list" style="height: 172px;">

                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        <button type="button" class="layui-btn layui-layout-right" id="upload"
                                style="margin-right: 38px;">
                            <i class="layui-icon">&#xe67c;</i>上传图片
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script src="layui/layui.js"></script>
<script>
    layui.use(['layer', 'upload', 'form'], function () {
        var layer = layui.layer;
        var jq = layui.$;

        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function (data) {
            var f = data.field;
            var text = f.text;
            var images = f.images;
            if (!text && !images) {
                layer.alert("请输入文本或者上传图片后方可提交！");
                return false;
            }
        });

        var upload = layui.upload;

        var loadIndex;
        //执行实例
        var uploadInst = upload.render({
            elem: '#upload', //绑定元素
            url: '/uploadImage', //上传接口
            multiple: true, //多图上传
            choose: function (obj) {
                //将每次选择的文件追加到文件队列
                var files = obj.pushFile();

                //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
                obj.preview(function (index, file, result) {
                    console.log(index); //得到文件索引
                    console.log(file); //得到文件对象
                    console.log(result); //得到文件base64编码，比如图片

//                <div style="width: 200px;float: left;margin: 2px">
//                        <img src="http://localhost:8080/images/20180413_045458_052786_8.jpg" alt="图片"
//                    style="max-height: 100%;max-width: 100%;">
//                        <button type="button" class="layui-btn layui-btn-danger" style="width: 100%;height: 30px">删除</button>
//                        </div>
                    var div = '' +
                        '<div style="width: 200px;float: left;margin: 2px">' +
                        '   <a href="' + result + '" target="_blank" style="height: 150px;"><img src="' + result + '" alt="' + file.name + '" style="max-height: 100%;max-width: 100%;"></a>' +
                        '   <button type="button" class="layui-btn layui-btn-danger js-del-img" style="width: 100%;">删除</button>' +
                        '</div>';
                    // 添加图片
                    jq("#img-list").append(div);
                    jq("#img-del-" + index).click(function () {
                        delete files[index]; //删除列表中对应的文件，一般在某个事件中使用
//                        jq("#img-"+index).parent().remove();
                    })

                    //obj.upload(index, file); //对上传失败的单个文件重新上传，一般在某个事件中使用

                });
            },
            before: function (obj) { //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
                loadIndex = layer.load(); //上传loading
            },
            done: function (res, index, upload) { //上传完毕回调
                layer.close(loadIndex);
                layer.msg(res.msg);
                if (res.code == "0") {
                    var img = res.data;
                    var div = '' +
                        '<div style="width: 200px;float: left;margin: 2px">' +
                        '   <a href="' + img.url + '" target="_blank" style="height: 150px;"><img src="' + img.url + '" alt="' + img.name + '" style="max-height: 100%;max-width: 100%;"></a>' +
                        '   <button type="button" class="layui-btn layui-btn-danger js-del-img" style="width: 100%;">删除</button>' +
                        '</div>';
                    // 添加图片
                    jq("#img-list").append(div);

                    var images = jq("#images").val();
                    images = jq.trim(images) + img.url + ",";
                    jq("#images").val(images);
                    console.log(img);
                } else {
//                    var item = this.item;
//                    item.upload()
                }
            },
            error: function (res) {//请求异常回调
                layer.close(loadIndex);
                layer.msg(res)
            }
        });

        // 图片删除
        jq(document).on("click", ".js-del-img", function () {
            jq(this).parent().remove();
        });

    })
</script>
</html>
