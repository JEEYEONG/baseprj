<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head></head>
<body>
<form:form id="loginForm"  class="form form-signIn" method="post"
           action="/login">
    <div class="img_wrapper">
        <img class="mb-4" src="/static/img/logo.PNG" alt="" width="72" height="72"/>
    </div>
    <label for="userId" class="login_input">아이디</label>
    <form:input path="userId" type="text" id="userId" class="form-control" name="userId"
                placeholder="아이디를 입력해주세요"
                required=""
                autofocus=""/>
    <div class="error_box"><form:errors path="userId"/></div>
    <label for="secretNum" class="login_input">비밀번호</label>
    <form:input path="secretNum" type="password" id="secretNum" name="secretNum"
                class="form-control"
                placeholder="비밀번호를 입력해주세요"
                required=""/>
    <div class="error_box"><form:errors path="secretNum"/></div>
    <button id="login_btn" class="btn btn-lg btn-primary btn-block" type="button">로그인</button>
    <p class="mt-5 mb-3 text-muted">© 2017-2022</p>
</form:form>
<script>
  $(document).ready(function () {
    $("#login_btn").click(function () {
      let userId = $("input[name=userId]").val();
      let secretNum = $('input[name=secretNum]').val();

      $.ajax({
        type: "POST",
        contentType: 'application/json; charset=utf-8',
        url: "/login", // 실제 요청할 URL 설정
        data: JSON.stringify({
          "userId": userId,
          "secretNum": secretNum
        }),
        success: function (response) {
          // 서버로부터의 응답 처리
          // response에 서버에서 보낸 데이터가 들어있습니다.
          // 예를 들어, 가입 성공 시 페이지 리다이렉션 등을 수행할 수 있습니다.
          // window.location.href = "/success-page";
          let requestURI = '<c:out value='${param.redirectURL}'/>';

          location.href = (requestURI == null || requestURI === '/') ? '/' : requestURI;
        },
        error: function (xhr, textStatus, errorThrown) {
          let responseJson = xhr.responseJSON;

          if (responseJson.code) {
            alert(responseJson.message);
          }
        }
      });
    });
  });
</script>


</body>
</html>