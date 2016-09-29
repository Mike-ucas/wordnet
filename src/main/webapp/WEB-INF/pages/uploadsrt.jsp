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
    <title>上传字幕</title>
</head>
<body>
<form action="/wordnet/uploadsrt" method="post" enctype="multipart/form-data">
    <h2>单独上传字幕：</h2><br/>
    <h3>输入对应视频名称：（结尾加上*.mp4）</h3>
    <input type="text" name="videoname" /><br/>
    <h3>上传字幕：</h3>
    <input type="file" name="srt1" value="请上传字幕" /><br/>
    <input type="submit" value="Submit" /><br/>
</form>

</body>
</html>
