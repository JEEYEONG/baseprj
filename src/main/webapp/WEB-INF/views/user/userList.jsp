<%--
  Created by IntelliJ IDEA.
  User: imcore1
  Date: 2023-08-30
  Time: 오후 2:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>회원목록</title>
</head>
<body>

<table border="1"  align="center"  width="80%">
    <tr align="center"   bgcolor="#f5f5dc">
        <td ><b>아이디</b></td>
        <td><b>비밀번호</b></td>
        <td><b>사용자 구분</b></td>
        <td><b>권한 그룹 코드</b></td>
    </tr>
    <c:forEach var="userList" items="${userLists}" >
        <tr align="center">
            <td>${userList.userId}</td>
            <td>${userList.secretNum}</td>
            <td>${userList.userNm}</td
        </tr>
    </c:forEach>
</table>



</body>
</html>
