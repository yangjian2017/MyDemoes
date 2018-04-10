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

<div class="layui-container layui-bg-orange">
    <div class="layui-row">
        <div class="layui-col-md8 layui-col-md-offset2 layui-col-xs10 layui-col-xs-offset1 layui-bg-gray">
            <form class="layui-form" action="/record/save">
                <input type="hidden" id="images">
                <div class="layui-form-item layui-form-text">
                    <%--<label class="layui-form-label">文本域</label>--%>
                    <div class="layui-input-block">
                        <textarea name="text" placeholder="请输入内容" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <button type="button" class="layui-btn" id="upload">
                        <i class="layui-icon">&#xe67c;</i>上传图片
                    </button>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
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
            layer.msg(JSON.stringify(data.field));
            return false;
        });

        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#upload', //绑定元素
            url: '/uploadImage/', //上传接口
//            multiple:true, //多图上传
            choose: function (obj) {
                //将每次选择的文件追加到文件队列
                var files = obj.pushFile();

                //预读本地文件，如果是多文件，则会遍历。(不支持ie8/9)
                obj.preview(function (index, file, result) {
                    console.log(index); //得到文件索引
                    console.log(file); //得到文件对象
                    console.log(result); //得到文件base64编码，比如图片

                    //这里还可以做一些 append 文件列表 DOM 的操作

                    //obj.upload(index, file); //对上传失败的单个文件重新上传，一般在某个事件中使用
                    //delete files[index]; //删除列表中对应的文件，一般在某个事件中使用
                });
            },
            before: function (obj) { //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
                layer.load(); //上传loading
            },
            done: function (res, index, upload) { //上传完毕回调
                layer.msg(res.msg);
                if (res.code == "0") {
                    var imgUrl = res.data;
                    var images = jq("#images").val();
                    images = jq.trim(images) + imgUrl;
                    jq("#images").val(images);
                    console.log(imgUrl);
                } else {
//                    var item = this.item;
//                    item.upload()
                }
            },
            error: function () {//请求异常回调

            }
        });
    })
</script>
</html>
