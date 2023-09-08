<%--
  Created by IntelliJ IDEA.
  User: imcore1
  Date: 2023-08-30
  Time: 오전 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>사용자 등록</title>

    <style>
      .container {
        text-align: center;
        width: 800px;
      }

      .container h1 {
        margin: 0 0 40px 0;
      }

      .form-group {
        border-top: 1px solid dimgray;
        padding-top: 13px;
      }

      #form-top {
        border-top: 2px solid dimgray;
        padding-top: 13px;
      }

      #form-bottom {
        border-bottom: 2px solid dimgray;
        padding-bottom: 13px;
      }

      .form-group label {
        font-weight: bold;
        width: 200px;
        text-align: center;
        padding: 0 40px;


      }

      #userId {
        width: 385px;
      }

      .form-control {
        display: inline;
        width: 500px;
        margin: 0 0 0 30px;
        padding: 6px 17px;
        background-color: whitesmoke;
        border: none;
      }


      #id-check {
        display: inline;
        width: 100px;
        border: 1px solid #aaaaaa;
        height: 38px;
        margin-left: 10px;
        text-align: center;
      }

      #msg {
        margin: 5px auto;
        position: relative;
        top: 4px;
        left: -30px;
        color: indianred;
      }

      #id-check:hover {
        background-color: lightgrey;
      }


      .btn-wrap {
        margin-top: 27px;
        position: relative;
        left: 236px;
      }

      .btn-primary {
        width: 130px;
        height: 45px;
        margin: 0 15px;
        background-color: lightgray;
        border-radius: 0px;
        border: 1px solid dimgray;
        color: black;
      }

      .btn-primary:hover {
        background-color: silver;
        border: 1px solid dimgray;
        color: black;
      }

      .btn-primary:after {
        background-color: silver;
        border: 1px solid dimgray;
        color: black;
      }


    </style>
</head>
<body>
<form method="post" action="/signUp" name="joinForm" onsubmit="return isUserValidate()">
    <div class="container">
        <h1>사용자 등록</h1>
        <div class="form-group" id="form-top">

            <label for="userId">사용자 ID</label>
            <input type="text" class="form-control userid" id="userId" name="userId"
                   placeholder="사용자 아이디를 입력해주세요."
            >
            <input type="button" id="id-check" value="중복확인">
            <br><span id="msg"></span>
        </div>
        <div class="form-group">
            <label for="userNm">사용자 명</label>
            <input type="text" class="form-control" id="userNm" name="userNm"
                   placeholder="사용자 이름을 입력해주세요.">
        </div>
        <div class="form-group">
            <label for="secretNum">비밀번호</label>
            <input type="password" class="form-control" id="secretNum" name="secretNum"
                   placeholder="사용자 비밀번호를 입력해주세요.">
        </div>

        <div class="form-group">
            <label for="userDiv">사용자 구분</label>
            <input type="text" class="form-control" id="userDiv" name="userDiv"
                   placeholder="지점명을 입력해주세요.">
        </div>

        <div class="form-group" id="form-bottom">
            <label for="authGroupCd">권한 그룹 코드</label>
            <select class="form-control" id="authGroupCd" name="authGroupCd">
                <option value="root">ROOT</option>
                <option value="admin">ADMIN</option>
                <option value="user" selected>USER</option>
            </select>
        </div>

        <div class="btn-wrap">
            <button type="submit" class="btn btn-primary" >등록</button>
            <button type="button" class="btn btn-primary" onclick="location.href='/userList'">목록
            </button>
        </div>
    </div>
</form>

<script src="/static/js/user/userForm.js"></script>
</body>
</html>
