<%--
  Created by IntelliJ IDEA.
  User: imcore1
  Date: 2023-08-30
  Time: 오후 2:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원목록</title>

    <style>
      .content {


      }


      .userTable {
        position: fixed;
        width: 100%;
        top: 170px;

      }

      .table1 {
        margin: 0;
        width: 70%;
      }

      .signUp {
        position: fixed;
        right: 170px;


      }

      a {
        color: black;
      }

      a:hover {
        /*text-decoration: none;*/
        color: black;
      }

      .signUpbtn {
        text-align: center;
        vertical-align: middle;
        width: 50px;
        padding: 9px 14px;
        border-radius: 5px;
        border: 1px solid #aaa;
        transition: 0.4s;
        cursor: pointer;
      }
      .signUp a:hover{
        text-decoration: none;
      }
    </style>
</head>
<body>
<div class="content">

    <div class="signUp">
        <a class="signUpbtn" href="/signUp">등록</a>
    </div>


    <div class="userTable">
        <table border="1" align="center" class="table1">
            <thead>
            <tr align="center" bgcolor="#dcdcdc">
                <td><b>사용자 ID</b></td>
                <td><b>사용자 명</b></td>
                <td><b>비밀번호</b></td>
                <td><b>사용자 구분</b></td>
                <td><b>권한 그룹 코드</b></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="userList" items="${userLists}">
                <tr align="center">
                    <td>${userList.userId}</td>
                    <td><a href="/userDetail">${userList.userNm}</a></td>
                    <td>${userList.secretNum}</td>
                    <td>${userList.userDiv}</td>
                    <td>${userList.authGroupCd}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
