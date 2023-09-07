<%--
  Created by IntelliJ IDEA.
  User: imcore1
  Date: 2023-08-31
  Time: 오후 4:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!-- CSS only -->
<link rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


<html>
<head>
    <title>상세보기</title>
    <script>
      $(document).ready(function () {
        $('#delBtn').on("click", function () {
          if (confirm('회원을 삭제하시겠습니까?')) {
            alert("회원을 삭제하였습니다.");
          } else {
            return false;
          }
        });
      });
    </script>

    <style>
      .container {
        text-align: center;
        width: 800px;
        position: relative;
        top: 50px;
        font-size: 16px;
      }

      .container h1 {
        margin: 0 0 40px 0;
      }

      .form-group label {
        font-weight: bold;
        width: 200px;
        text-align: center;
        padding: 0 40px;


      }


      .form-control {
        display: inline;
        width: 500px;
        margin: 0 0 0 30px;
        padding: 6px 17px;
      }


      .btn-wrap {
        margin-top: 42px;
        position: relative;
        text-align: right;
      }

      .btn-primary {
        width: 110px;
        height: 45px;
        margin : 0 12px;
        background-color: lightgray;
        border-radius: 0px;
        border: 1px solid dimgray;
        color: black;
      }

      .btn-primary:hover{
        background-color: silver;
        border: 1px solid dimgray;
        color: black;
      }

      .btn-primary:after{
        background-color: silver;
        border: 1px solid dimgray;
        color: black;
      }


    </style>

</head>
<body>
<input type="hidden" id="userId" value="${userDtl.userId}">
<div class="container">
    <h1>사용자 상세보기</h1>

    <div class="form-group">
        <label for="inputId">사용자 ID</label>
        <input type="text" class="form-control" id="inputId" name="userId" value="${userDtl.userId}"
               readonly>
    </div>
    <div class="form-group">
        <label for="inputName">사용자 명</label>
        <input type="text" class="form-control" id="inputName" name="userNm"
               value="${userDtl.userNm}"
               readonly>
    </div>
    <div class="form-group">
        <label for="inputPassword">비밀번호</label>
        <input type="password" class="form-control" id="inputPassword" name="secretNum"
               value="${userDtl.secretNum}" readonly>
    </div>

    <div class="form-group">
        <label for="inputDiv">사용자 구분</label>
        <input type="text" class="form-control" id="inputDiv" name="userDiv"
               value="${userDtl.userDiv}"
               readonly>
    </div>

    <div class="form-group">
        <label for="inputGroup">권한 그룹 코드</label>
        <input type="text" class="form-control" id="inputGroup" name="authGroupCd"
               value="${userDtl.authGroupCd}" readonly>
    </div>

    <div class="btn-wrap">
        <button class="btn btn-primary" id="delBtn" type="button" onclick="location.href='/delete/${userId}'">삭제</button>
        <button class="btn btn-primary" type="button" onclick="location.href='/mod/${userDtl.userId}'">수정</button>
        <button class="btn btn-primary" type="button" onclick="location.href='/userList'">목록</button>
    </div>

</div>
</body>


</html>
