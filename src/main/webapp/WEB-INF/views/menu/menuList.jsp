<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>권한 관리</title>
    <style>
      .auth-menu-container {
        position: relative;
        width: 1000px;
        margin: 0 auto;
      }

      .auth-select {
        position: absolute;
        width: 220px;

      }

      .auth-select p {
        font-size: 18px;
        font-weight: bold;
      }

      .auth-group {
        margin-top: 7px;
        border: 1px solid #aaaaaa;
        width: 200px;
        height: 45px;
        padding-left: 5px;

      }

      .menu-wrap {
        position: absolute;
        top: 100px;
      }
      .menu-view {
        position: absolute;
        border: 1px solid #aaaaaa;
        border-radius: 2px;
        width: 400px;
        height: 600px;
      }

      .auth-menu-list {
        position: absolute;
        left: 650px;
        border: 1px solid #aaaaaa;
        border-radius: 2px;
        width: 400px;
        height: 600px;
      }

      .button-wrap {
        position: absolute;
        left: 500px;
      }

      .button-wrap button {
        width: 70px;
        height: 40px;
        border: 1px solid #aaaaaa;
        display: block;
        text-align: center;
        vertical-align: middle;
        padding-bottom: 3px;
        background-color: lightgrey;
        border-radius: 2px;

      }

      .all-in {
        margin-top: 140px;
        margin-bottom: 20px;
      }

      .one-out {
        margin-top: 100px;
        margin-bottom: 20px;
      }

      .menu-title, .auth-title {
        text-align: center;
        height: 50px;
        padding-top: 11px;
        background-color: lightgrey;
        font-weight: bold;
      }

      .saveBtn{
        border: 1px solid #aaaaaa;
        position: absolute;
        top: ;
      }

    </style>

</head>
<body>
<div class="auth-menu-container">
    <div class="auth-select">
        <p>권한 선택</p>
        <select class="auth-group">
            <option value="all">전체</option>
            <option value="root">ROOT</option>
            <option value="admin">ADMIN</option>
            <option value="user">USER</option>
        </select>
    </div>
    <div class="menu-wrap">
        <div class="menu-view">
            <div class="menu-title">MENU VIEW</div>


        </div>
        <div class="button-wrap">
            <div class="inBtn">
                <button class="all-in">>></button>
                <button class="one-in">></button>
            </div>
            <div class="outBtn">
                <button class="one-out"><</button>
                <button class="all-out"><<</button>

            </div>


        </div>
        <div class="auth-menu-list">
            <div class="auth-title">권한 목록</div>


        </div>
    </div>
    <div class="saveBtn">
        저장

    </div>
</div>


</body>
</html>
