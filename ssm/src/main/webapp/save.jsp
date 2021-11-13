<%--
  Created by IntelliJ IDEA.
  User: doris
  Date: 2021/11/13
  Time: 上午4:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>添加用户</h1>
    <form name="accountForm" action="${pageContext.request.contextPath}/account/save" method="post">
        账户名称 <input type="text" name="name"></br>
        账户金额 <input type="text" name="money"></br>
        <button type="submit">保存</button>
    </form>
</body>
</html>
