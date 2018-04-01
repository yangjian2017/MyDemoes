<%@ page import="org.nutz.json.Json" %>
<%@ page import="org.nutz.json.JsonFormat" %>
<%@ page import="cn.jt.bean.User" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <title>hello Nutz!</title>
</head>
<body>
<h2>欢迎光临，${obj.name}！</h2>
<h1>您的资料如下——</h1>
<p><%
    User user = (User) request.getAttribute("obj");
    String jsonStr = Json.toJson(user, JsonFormat.forLook().setLocked("uuid"));
    out.println(jsonStr);
%></p>
</body>
</html>
</html>