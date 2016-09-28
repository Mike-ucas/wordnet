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
    <title>upload</title>
</head>
<body>
<form action="/wordnet/saveuploads" method="post" enctype="multipart/form-data">
    <input type="file" name="file" />
    <input type="submit" value="Submit" />
</form>
</body>
</html>
