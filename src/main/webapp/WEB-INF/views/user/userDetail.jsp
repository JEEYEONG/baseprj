<%--
  Created by IntelliJ IDEA.
  User: imcore1
  Date: 2023-08-31
  Time: 오후 4:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>상세보기</title>
</head>
<body>

<form method="post" action="/userDelete">
    <button type="submit">삭제</button>
</form>

<form method="post" action="/userMod">
    <button type="submit">수정</button>
</form>

<button type="button" onclick="location.href='/userList'">목록</button>
</body>
</html>
