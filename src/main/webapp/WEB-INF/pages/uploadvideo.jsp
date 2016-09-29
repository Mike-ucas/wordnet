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
    <title>上传视频</title>
</head>
<body>
<form action="/wordnet/uploadvideo" method="post" enctype="multipart/form-data">
    <h2>上传视频和对应字幕：</h2><br/>
    <h3>1.上传视频：</h3>
    <input type="file" name="video" /><br/>
    <h3>视频类别：</h3><select name="videotype" >
    <option value="">请选择</option>
    <option value="economic" selected>经济金融</option>
    <option value="education">求学教育</option></select><br/>
    <h3>2.对应字幕：</h3>
    <input type="file" name="srt" /><br/>
    <input type="submit" value="Submit" /><br/>
</form>
</body>
</html>
