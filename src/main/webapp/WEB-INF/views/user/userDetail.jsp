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
<input type="hidden" id="userId" value="${userDtl.userId}">
<h1>사용자 상세보기</h1>
<div class="form-group">
    <label for="inputId">사용자 ID</label>
    <input type="text" class="form-control" id="inputId" name="userId" value="${userDtl.userId}"
           readonly>
</div>
<div class="form-group">
    <label for="inputName">사용자 명</label>
    <input type="text" class="form-control" id="inputName" name="userNm" value="${userDtl.userNm}"
           readonly>
</div>
<div class="form-group">
    <label for="inputPassword">비밀번호</label>
    <input type="password" class="form-control" id="inputPassword" name="secretNum"
           value="${userDtl.secretNum}" readonly>
</div>

<div class="form-group">
    <label for="inputDiv">사용자 구분</label>
    <input type="text" class="form-control" id="inputDiv" name="userDiv" value="${userDtl.userDiv}"
           readonly>
</div>

<div class="form-group">
    <label for="inputGroup">권한 그룹 코드</label>
    <input type="text" class="form-control" id="inputGroup" name="authGroupCd"
           value="${userDtl.authGroupCd}" readonly>
</div>

<button type="button" onclick="location.href='/delete/${userId}'">삭제</button>
<button type="button" onclick="location.href='/mod/${userDtl.userId}'">수정</button>
<button type="button" onclick="location.href='/userList'">목록</button>
</body>


</html>
