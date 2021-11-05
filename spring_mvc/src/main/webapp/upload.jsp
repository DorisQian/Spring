<%--
  Created by IntelliJ IDEA.
  User: doris
  Date: 2021/11/6
  Time: 上午2:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick22" method="post" enctype="multipart/form-data">
        名称 <input type="text" name="name"></br>
        文件 <input type="file" name="uploadFile"></br>
        <button type="submit">提交</button>
    </form>
    <form action="${pageContext.request.contextPath}/user/quick23" method="post" enctype="multipart/form-data">
        名称 <input type="text" name="name"></br>
        文件 <input type="file" name="uploadFile"></br>
        文件 <input type="file" name="uploadFile"></br>
        <button type="submit">提交</button>
    </form>
</body>
</html>
