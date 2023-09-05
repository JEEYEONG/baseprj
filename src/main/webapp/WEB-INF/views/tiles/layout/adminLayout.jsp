<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <title>BASE ADMIN</title>
    <script src="/static/js/jquery.js"></script>
    <script src="/static/js/jquery.form.min.js"></script>
    <script src="/static/js/jquery-ui.min.js"></script>
    <script src="/static/js/common.js"></script>

    <%--    부트스트랩--%>
    <!-- CSS only -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <style>
      div.left {
        width: 20%;
        float: left;
      }

      div.right {
        width: 80%;
        float: right;
      }
    </style>
</head>

<body>
<div class="content">
    <tiles:insertAttribute name="adminHeader"/>
    <div class="wrap">
        <tiles:insertAttribute name="body"/>
    </div>
</div>
</body>
</html>
