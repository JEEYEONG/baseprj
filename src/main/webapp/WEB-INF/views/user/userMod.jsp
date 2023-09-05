<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: imcore1
  Date: 2023-08-30
  Time: 오전 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- CSS only -->
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>


<html>
<head>
    <title>사용자 수정</title>

    <style>
      .btn-primary {
        width: 130px;
        height: 45px;
      }

    </style>


    <script type="text/javascript">

    </script>
</head>

<body>
<form method="post" action="/mod/<c:out value='${userId}'/>">
    <input type="hidden" id="userId" value="${userDtl.userId}">
    <div class="container">
        <h1>사용자 수정</h1>
        <div class="form-group">
            <label for="inputId">사용자 ID</label>
            <input type="text" class="form-control" id="inputId" name="userId"
                   value="${userDtl.userId}"
                   readonly>
        </div>
        <div class="form-group">
            <label for="inputName">사용자 명</label>
            <input type="text" class="form-control" id="inputName" name="userNm"
                   value="${userDtl.userNm}" required
                   oninvalid="this.setCustomValidity('이름를 입력해주세요.')">
        </div>
        <div class="form-group">
            <label for="inputPassword">비밀번호</label>
            <input type="password" class="form-control" id="inputPassword" name="secretNum"
                   value="${userDtl.secretNum}" required
                   oninvalid="this.setCustomValidity('비밀번호를 입력해주세요.')">
        </div>

        <div class="form-group">
            <label for="inputDiv">사용자 구분</label>
            <input type="text" class="form-control" id="inputDiv" name="userDiv"
                   value="${userDtl.userDiv}">
        </div>

        <div class="form-group">
            <label for="inputGroup">권한 그룹 코드</label>
            <select class="form-control" id="inputGroup" name="authGroupCd"
                    value="${userDtl.authGroupCd}">
                <option value="root" <c:if test="${userDtl.authGroupCd eq 'root'}">selected</c:if>>ROOT</option>
                <option value="admin" <c:if test="${userDtl.authGroupCd eq 'admin'}">selected</c:if>>ADMIN</option>
                <option value="user" <c:if test="${userDtl.authGroupCd eq 'user'}">selected</c:if>>USER</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">수정 완료</button>
        <button type="button" class="btn btn-primary" onclick="location.href='/userList'">목록
        </button>
    </div>
</form>
</body>
</html>
