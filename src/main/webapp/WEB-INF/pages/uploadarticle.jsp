<%--
  Created by IntelliJ IDEA.
  User: Wang Haobo
  Date: 2016/9/26
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文章</title>
</head>
<body>
<form action="/wordnet/uploadarticle" method="post" enctype="multipart/form-data">
    <h2>上传文章：</h2><br/>
    <h3>文章标题：</h3> <input type="text" name="title" /><br/>
    <h3>文章作者：</h3><input type="text" name="author" /><br/>
    <h3>上传文章正文:</h3> <input type="file" name="article" /><br/>
    <input type="submit" value="Submit" /><br/>
</form>
</body>
</html>
