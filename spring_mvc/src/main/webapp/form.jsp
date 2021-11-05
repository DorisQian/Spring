<%--
  Created by IntelliJ IDEA.
  User: doris
  Date: 2021/11/6
  Time: 上午12:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/user/quick14" method="post">
<%--    userlist    表明是第几个user对象的username--%>
<%--        userList[0].username  userList是VO对象的属性，是一个User的list [0]表示第一个集合对象，第一个User对象 username对应的是User中的username--%>
        <input type="text" name="userList[0].username"></br>
        <input type="text" name="userList[0].age"></br>
        <input type="text" name="userList[1].username"></br>
        <input type="text" name="userList[1].age"></br>
        <button type="submit">提交</button>
    </form>
</body>
</html>
