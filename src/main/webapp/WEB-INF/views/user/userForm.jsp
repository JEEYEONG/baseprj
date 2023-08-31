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

<html>
<head>
    <title>사용자 등록</title>
</head>

<body>
<form method="post" action="/signUp">
    <div class="container">
        <h1>사용자 등록</h1>
        <div class="form-group">
            <label for="inputId">사용자 ID</label>
            <input type="text" class="form-control" id="inputId" name="userId"
                   placeholder="사용자 아이디">
        </div>
        <div class="form-group">
            <label for="inputName">사용자 명</label>
            <input type="text" class="form-control" id="inputName" name="userNm"
                   placeholder="사용자 이름">
        </div>
        <div class="form-group">
            <label for="inputPassword">비밀번호</label>
            <input type="password" class="form-control" id="inputPassword" name="secretNum"
                   placeholder="사용자 비밀번호">
        </div>
        <%--    <div class="form-group">--%>
        <%--      <label for="inputPassword1">비밀번호 확인</label>--%>
        <%--      <input type="password" class="form-control" id="inputPassword1" name="secretNum" placeholder="사용자 비밀번호">--%>
        <%--    </div>--%>

        <div class="form-group">
            <label for="inputDiv1">사용자 구분</label>
            <select class="form-control" id="inputDiv1" name="userDiv">
                <option value="admin">ADMIN</option>
                <option value="user">USER</option>

            </select>
        </div>

        <div class="form-group">
            <label for="inputGroup">권한 그룹 코드</label>
            <select class="form-control" id="inputGroup" name="authGroupCd">
                <option value="root">ROOT</option>
                <option value="admin">ADMIN</option>
                <option value="user">USER</option>
            </select>
        </div>


        <button type="submit" class="btn btn-primary">등록 완료</button>
    </div>
</form>
</body>
</html>
