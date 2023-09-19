<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원목록</title>

    <style>
      .content {
        width: 1000px;
        margin: 0 auto;

      }

      .userTable {
        position: relative;
        top: 90px;
      }

      .table1 {
        margin: 0;
        width: 1050px;
        position: relative;
      }

      .table1 tr, td {
        padding: 5px;
        border: 1px solid black;
      }

      .signUp {
        position: relative;
        left: 310px;
        bottom: 10px;
      }

      a {
        color: black;
      }

      a:hover {
        color: black;
      }

      .signUpbtn {
        position: absolute;
        left: 670px;
        top: 40px;
        text-align: center;
        vertical-align: middle;
        width: 70px;
        padding: 9px 14px;
        border: 1px solid #aaa;
        transition: 0.4s;
        cursor: pointer;
      }

      .signUp a:hover {
        text-decoration: none;
      }

      .user-pagination {
        position: relative;
        margin: 0 auto;
        left: 460px;
        top: 30px;
      }

      .page-link {
        color: black;
      }
    </style>
</head>
<body>
<form name="dataForm" id="dataForm" method="post">
    <%--<input type="hidden" id="agencyId" name="agencyId">
    <input type='hidden' name='tranMod' id='tranMod'>--%>
    <input type='hidden' name='currentPage' id='currentPage' value='${p.currentPage}'/>
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
                        <td>
                            <a href="/userDetail/<c:out value='${userList.userId}'/>">${userList.userId}</a>
                        </td>
                        <td>${userList.userNm}</td>
                        <td>${userList.secretNum}</td>
                        <td>${userList.userDiv}</td>
                        <td>${userList.authGroupCd}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


            <div class="user-pagination">
                <nav aria-label="Page navigation example">
                    <ul class="pagination">


                        <c:if test="${page.showPrev}">
                            <li class="page-item">
                                <a class="page-link" href="userList?pageNum=${page.beginPage - 1}"
                                   aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:forEach var="i" begin="${page.beginPage}" end="${page.endPage}">
                            <li class="page-item"><a class="page-link"
                                                     href="<c:url value="/userList${page.getUserQueryString(i)}"/>">${i}</a>
                            </li>
                        </c:forEach>
                        <c:if test="${page.showNext}">
                            <li class="page-item">
                                <a class="page-link" href="userList?pageNum=${page.endPage - 1}"
                                   aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </nav>
            </div>


        </div>

    </div>

</form>
</body>
</html>
